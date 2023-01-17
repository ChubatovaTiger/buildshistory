import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script


version = "2022.10"

project {

    buildType(Build210xyz0n)
    buildType(Build1130xyzn)
}

object Build1130xyzn : BuildType({
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

object Build210xyz0n : BuildType({
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
