organization  := "com.example"

version       := "0.1"

scalaVersion  := "2.10.3"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/"
)

libraryDependencies <+= (scalaVersion)("org.scala-lang" % "scala-compiler" % _)

libraryDependencies ++= {
  val akkaV = "2.2.3"
  val sprayV = "1.2-RC1"
  Seq(
    "io.spray"            %   "spray-servlet" % sprayV,
    "io.spray"            %   "spray-routing" % sprayV,
    "io.spray"            %   "spray-testkit" % sprayV,
    "io.spray"            %   "spray-httpx" % sprayV,
    "io.spray"            %%   "spray-json" % "1.2.5",
    "org.eclipse.jetty"       %   "jetty-webapp"  % "8.1.13.v20130916"    % "container",
    "org.eclipse.jetty.orbit" %   "javax.servlet" % "3.0.0.v201112011016" % "container"  artifacts Artifact("javax.servlet", "jar", "jar"),
    "org.scala-lang"      % "scala-reflect" % "2.10.3", // make sure it is the same as the scala version, otherwise weird errors will pop up
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV,
    "com.typesafe.slick"  % "slick_2.10" % "2.0.0-M2",
    "postgresql"          % "postgresql" % "9.1-901.jdbc4",
    "org.specs2"          %%  "specs2"        % "2.2.3" % "test"
  )
}

seq(webSettings: _*)
