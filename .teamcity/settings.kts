import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script


version = "2022.10"

project {

    buildType(Build210xyz0nd)
    buildType(Build1130xyznc)
}

object Build1130xyznc : BuildType({
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

object Build210xyz0nd : BuildType({
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
