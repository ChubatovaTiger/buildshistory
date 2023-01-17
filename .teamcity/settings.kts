import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script


version = "2022.10"

project {

    buildType(Build2)
    buildType(Build1130xyznc2o)
}

object Build1130xyznc2o : BuildType({
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
            scriptContent = "echo hi"
        }
    }
})

object Build2 : BuildType({
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
