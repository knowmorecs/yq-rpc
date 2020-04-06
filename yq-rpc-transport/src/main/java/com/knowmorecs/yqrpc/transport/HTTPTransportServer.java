package com.knowmorecs.yqrpc.transport;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 使用Jetty容器完成init(),start(),stop()功能。
 * 最重要一个关注点在于RequestHandler实例的初始化，该抽象类定义于Transport模块，
 * 主要用于server处理来自client的请求。其抽象方法实现将在RpcServer类中详细讲解。
 *
 * @author knowmoreCS
 * @create 2020-04-05 15:43
 */
@Slf4j
public class HTTPTransportServer implements TransportServer {
    private RequestHandler handler;
    private Server server;

    @Override
    public void init(int port, RequestHandler handler) {
        this.handler = handler;
        this.server = new Server(port);

        //Servlet接受请求
        ServletContextHandler ctx = new ServletContextHandler();
        server.setHandler(ctx);

        //ServletHolder是jetty  在处理网络请求时的一个抽象
        ServletHolder holder = new ServletHolder(new RequestServlet());
        ctx.addServlet(holder, "/*");
    }

    @Override
    public void start() {
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void stop() {
        try {
            server.stop();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    //声明一个内部类
    //HttpServlet是JavaWeb开发里的Servlet
    class RequestServlet extends HttpServlet{
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            log.info("client connect");

            InputStream in = req.getInputStream();
            OutputStream out = resp.getOutputStream();

            if (handler != null){
                handler.onRequest(in, out);
            }
            out.flush();
        }
    }
}
