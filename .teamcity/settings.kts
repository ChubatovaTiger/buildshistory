import jetbrains.buildServer.configs.kotlin.*



version = "2022.10"

project {

    buildType(Build111)
}

object Build111 : BuildType({
    name = "build1"
  
    vcs {
        root(DslContext.settingsRoot)
    }
})
