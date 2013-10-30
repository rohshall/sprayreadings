package com.example

import scala.slick.driver.PostgresDriver
import scala.slick.driver.PostgresDriver.simple.{Session, Database}
import scala.slick.direct._
import scala.slick.direct.AnnotationMapper._
import scala.reflect.runtime.universe
import scala.slick.jdbc.StaticQuery.interpolation

// define classes
@table("device_types") case class DeviceType(
  @column("id") id: Int,
  @column("name") name: String,
  @column("version") version: String
)

class Domain extends Configuration {
  // init Database instance
  val db = Database.forURL(url = "jdbc:postgresql://%s:%s/%s".format(dbHost, dbPort, dbName),
	  user = dbUser, password = dbPassword, driver = "org.postgresql.Driver")
  val backend = new SlickBackend(PostgresDriver, AnnotationMapper)
  def query[T]( q:QueryableValue[T] )(implicit session:Session) : T = backend.result(q, session)
  def query[T]( q:Queryable[T] )(implicit session:Session) : Vector[T] = backend.result(q, session)
  val deviceTypes = Queryable[DeviceType]

  def get: DeviceType = db withSession { implicit session:Session =>
      val device_type: DeviceType = query(deviceTypes.filter(_.id == 1)).head
      device_type
    }
}

