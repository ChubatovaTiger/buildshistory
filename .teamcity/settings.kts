import jetbrains.buildServer.configs.kotlin.*



version = "2022.10"

project {

    buildType(Build11)
}

object Build11 : BuildType({
    name = "build1"
  
    vcs {
        root(DslContext.settingsRoot)
    }
})
