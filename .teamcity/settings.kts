import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script


version = "2022.10"

project {

    buildType(Build210xyz)
    buildType(Build1130xyz)
}

object Build1130xyz : BuildType({
    name = "build1"

    artifactRules = "+:*.txt => ."

    params {
        param("a", "a")
    }

    vcs {
        root(DslContext.settingsRoot)

        cleanCheckout = true
    }

    steps {
        script {
            scriptContent = "echo a > %build.counter%.txt"
        }
    }
})

object Build210xyz0 : BuildType({
    name = "build2"

    artifactRules = "+:*.txt => ."

    vcs {
        root(DslContext.settingsRoot)

        cleanCheckout = true
    }

    steps {
        script {
            scriptContent = "echo a > %build.counter%.txt"
        }
    }
})
