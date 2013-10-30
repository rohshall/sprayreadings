package com.example

import com.typesafe.config.ConfigFactory

trait Configuration {
  /**
  * Application config object.
  */
  val config = ConfigFactory.load()

  /** Database host name/address. */
  lazy val dbHost = config.getString("db.host")
  /** Database host port number. */
  lazy val dbPort = config.getInt("db.port")
  /** Service database name. */
  lazy val dbName = config.getString("db.name")
  /** User name used to access database. */
  lazy val dbUser = config.getString("db.user")
  /** Password for specified user and database. */
  lazy val dbPassword = config.getString("db.password")
}
