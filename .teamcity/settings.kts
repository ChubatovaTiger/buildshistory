import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2022.10"

project {

    buildType(Build2_2)
    buildType(Build21)
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

object Build21 : BuildType({
    name = "build2"

    artifactRules = "+:*.txt => ."

    vcs {
        root(DslContext.settingsRoot)

        cleanCheckout = true
    }

    steps {
        script {
            scriptContent = "ping 127.0.0.1 -n 200 > nul"
        }
    }

    cleanup {
        baseRule {
            history(builds = 2)
        }
    }
})

object Build2_2 : BuildType({
    name = "build2 (1)"

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

    cleanup {
        baseRule {
            history(builds = 2)
        }
    }
})
