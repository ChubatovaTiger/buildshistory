import jetbrains.buildServer.configs.kotlin.*



version = "2022.10"

project {

    buildType(Build1)
}

object Build1 : BuildType({
    name = "build1"

    vcs {
        root(DslContext.settingsRoot)
    }
})
