package net.corda.demobench.web

import net.corda.demobench.model.JVMConfig
import tornadofx.Controller

class WebServerController : Controller() {

    private val jvm by inject<JVMConfig>()
    private val webserverPath = jvm.applicationDir.resolve("corda").resolve("corda-webserver.jar")

    init {
        log.info("Web Server JAR: $webserverPath")
    }

    internal fun process() = jvm.processFor(webserverPath)

    fun webServer() = WebServer(this)

}
