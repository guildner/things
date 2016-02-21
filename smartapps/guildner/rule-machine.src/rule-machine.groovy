/**
 *  Rule Machine
 *
 *  Copyright 2016 Luke Guildner
 *
 */
definition(
    name: "Rule Machine",
    namespace: "guildner",
    author: "Luke Guildner",
    description: "A rule machine.",
    category: "My Apps",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png")

preferences {
    page(name: "mainPage", title: "Rules", install: true, uninstall: true,submitOnChange: true) {
            section {
                    app(name: "childRules", appName: "Rule", namespace: "guildner", title: "Create New Rule...", multiple: true)
            }
    }
}

def installed() {
    initialize()
}

def updated() {
    unsubscribe()
    initialize()
}

def initialize() {
    childApps.each {child ->
            log.info "Installed Rules: ${child.label}"
    }
}