package io.vertx.howtos.jlink;

import io.vertx.core.Verticle;
import io.vertx.launcher.application.VertxApplication;
import io.vertx.launcher.application.VertxApplicationHooks;

import java.util.function.Supplier;

public class CustomLauncher extends VertxApplication implements VertxApplicationHooks {

  public static void main(String[] args) {
    CustomLauncher vertxApplication = new CustomLauncher(args);
    vertxApplication.launch();
  }

  public CustomLauncher(String[] args) {
    super(args);
  }

  @Override
  public Supplier<Verticle> verticleSupplier() {
    return ServerVerticle::new;
  }
}
