import jetbrains.buildServer.configs.kotlin.*



version = "2022.10"

project {

    buildType(Build11)
}

object Build11 : BuildType({
    name = "build1"
    id = "id74019_Project1_Build11"
    vcs {
        root(DslContext.settingsRoot)
    }
})
