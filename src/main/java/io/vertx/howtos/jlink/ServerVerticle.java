package io.vertx.howtos.jlink;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.ext.web.Router;

import java.util.logging.Logger;

public class ServerVerticle extends AbstractVerticle {

  private static final Logger LOG = Logger.getLogger(ServerVerticle.class.getName());

  @Override
  public void start(Promise<Void> startPromise) {
    Router router = Router.router(vertx);

    router.get().respond(rc -> Future.succeededFuture("Hello World!"));

    vertx.createHttpServer()
      .requestHandler(router)
      .listen(8888)
      .onSuccess(http -> LOG.info("HTTP server started on port 8888"))
      .<Void>mapEmpty()
      .onComplete(startPromise);
  }
}
