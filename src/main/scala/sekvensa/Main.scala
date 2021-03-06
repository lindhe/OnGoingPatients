package sekvensa

import akka.actor.ActorSystem
import akka.event.Logging
import akka.stream.ActorMaterializer

/**
  * Created by elin on 2016-02-12.
  */
object Main extends App {

  implicit val system = ActorSystem()
  implicit val executor = system.dispatcher
  implicit val materializer = ActorMaterializer()
  val logger = Logging(system, "SimpleService")

  val transformActor = system.actorOf(sekvensa.Patient.props)
  transformActor ! "connect"

  // Start a rest API - example
  //val (interface, port) = (config.getString("http.interface"), config.getInt("http.port"))
  //logger.info(s"Starting service on port $port")
  //Http().bindAndHandle(routes, interface, port)
}
