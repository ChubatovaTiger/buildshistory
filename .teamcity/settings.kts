import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.projectFeatures.activeStorage
import jetbrains.buildServer.configs.kotlin.projectFeatures.s3Storage

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

    buildType(Build20)
    buildType(Build2_2)
    buildType(Build2111nas)
    buildType(Build1xnas)

    features {
        s3Storage {
            id = "PROJECT_EXT_52"
            bucketName = "n.chubatova-test"
            bucketPrefix = "a"
            awsEnvironment = default {
                awsRegionName = "eu-central-1"
            }
            accessKeyID = "AKIA5JH2VERVHVMPJQJI"
            accessKey = "credentialsJSON:c7a2cd00-90f2-414a-876e-a5cb4bc3236d"
        }
        activeStorage {
            id = "PROJECT_EXT_53"
            activeStorageID = "PROJECT_EXT_52"
        }
    }
}

object Build1xnas : BuildType({
    name = "build1 (1)"

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
            scriptContent = "echo hi > %build.counter%.txt"
        }
    }
})

object Build20 : BuildType({
    name = "build20"

    artifactRules = "+:*.txt => ."

    vcs {
        root(DslContext.settingsRoot)

        cleanCheckout = true
    }

    steps {
        script {
            scriptContent = "ping 127.0.0.1 -n 20 > nul"
        }
    }

    cleanup {
        baseRule {
            history(builds = 2)
        }
    }
})

object Build2111nas : BuildType({
    name = "build2"

    artifactRules = "+:*.txt => ."

    vcs {
        root(DslContext.settingsRoot)

        cleanCheckout = true
    }

    steps {
        script {
            scriptContent = "ping 127.0.0.1 -n 2 > nul"
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
