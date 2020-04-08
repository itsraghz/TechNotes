# Install the recommended plugins on Jenkins.

*Note*: A few plugins failed and it suggests to retry after sometime, or manuall install them.


```
.......
2020-04-08 18:09:39.050+0000 [id=21]    INFO    hudson.WebAppMain$3#run: Jenkins is fully up and running

2020-04-08 18:17:54.415+0000 [id=12]    INFO    hudson.PluginManager#install: Starting installation of a batch of 20 plugins plus their dependencies
2020-04-08 18:17:54.420+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of trilead-api for plugin cloudbees-folder
2020-04-08 18:17:54.428+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of command-launcher for plugin build-timeout
2020-04-08 18:17:54.429+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of trilead-api on behalf of admin
2020-04-08 18:17:54.430+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of script-security for plugin command-launcher
2020-04-08 18:17:54.433+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of jdk-tool for plugin script-security
2020-04-08 18:17:54.435+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of token-macro for plugin build-timeout
2020-04-08 18:17:54.440+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of structs for plugin token-macro
2020-04-08 18:17:54.441+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of workflow-step-api for plugin token-macro
2020-04-08 18:17:54.443+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of bouncycastle-api for plugin build-timeout
2020-04-08 18:17:54.445+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of plain-credentials for plugin credentials-binding
2020-04-08 18:17:54.447+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of credentials for plugin plain-credentials
2020-04-08 18:17:54.448+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of ssh-credentials for plugin credentials-binding
2020-04-08 18:17:54.450+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of workflow-api for plugin timestamper
2020-04-08 18:17:54.452+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of scm-api for plugin workflow-api
2020-04-08 18:17:54.454+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of workflow-durable-task-step for plugin ws-cleanup
2020-04-08 18:17:54.456+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of workflow-support for plugin workflow-durable-task-step
2020-04-08 18:17:54.458+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of durable-task for plugin workflow-durable-task-step
2020-04-08 18:17:54.461+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of matrix-project for plugin ws-cleanup
2020-04-08 18:17:54.463+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of junit for plugin matrix-project
2020-04-08 18:17:54.465+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of resource-disposer for plugin ws-cleanup
2020-04-08 18:17:54.468+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of workflow-cps for plugin gradle
2020-04-08 18:17:54.480+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of ace-editor for plugin workflow-cps
2020-04-08 18:17:54.482+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of jquery-detached for plugin workflow-cps
2020-04-08 18:17:54.483+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of workflow-scm-step for plugin workflow-cps
2020-04-08 18:17:54.485+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of workflow-job for plugin gradle
2020-04-08 18:17:54.487+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of workflow-basic-steps for plugin gradle
2020-04-08 18:17:54.489+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of apache-httpcomponents-client-4-api for plugin workflow-basic-steps
2020-04-08 18:17:54.492+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of mailer for plugin workflow-basic-steps
2020-04-08 18:17:54.494+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of display-url-api for plugin mailer
2020-04-08 18:17:54.496+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of pipeline-milestone-step for plugin workflow-aggregator
2020-04-08 18:17:54.498+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of pipeline-stage-view for plugin workflow-aggregator
2020-04-08 18:17:54.500+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of pipeline-rest-api for plugin pipeline-stage-view
2020-04-08 18:17:54.501+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of jackson2-api for plugin pipeline-rest-api
2020-04-08 18:17:54.503+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of pipeline-graph-analysis for plugin pipeline-rest-api 2020-04-08 18:17:54.506+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of pipeline-input-step for plugin pipeline-graph-analysis
2020-04-08 18:17:54.508+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of pipeline-stage-step for plugin pipeline-graph-analysis
2020-04-08 18:17:54.511+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of handlebars for plugin pipeline-stage-view
2020-04-08 18:17:54.513+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of momentjs for plugin pipeline-stage-view
2020-04-08 18:17:54.514+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of pipeline-build-step for plugin workflow-aggregator
2020-04-08 18:17:54.517+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of pipeline-model-definition for plugin workflow-aggregator
2020-04-08 18:17:54.520+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of pipeline-model-extensions for plugin pipeline-model-definition
2020-04-08 18:17:54.522+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of pipeline-model-api for plugin pipeline-model-extensions
2020-04-08 18:17:54.524+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of workflow-cps-global-lib for plugin pipeline-model-definition
2020-04-08 18:17:54.526+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of git-server for plugin workflow-cps-global-lib
2020-04-08 18:17:54.529+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of git-client for plugin git-server
2020-04-08 18:17:54.531+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of jsch for plugin git-client
2020-04-08 18:17:54.533+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of workflow-multibranch for plugin pipeline-model-definition
2020-04-08 18:17:54.534+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of branch-api for plugin workflow-multibranch
2020-04-08 18:17:54.536+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of docker-workflow for plugin pipeline-model-definition 2020-04-08 18:17:54.537+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of docker-commons for plugin docker-workflow
2020-04-08 18:17:54.539+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of authentication-tokens for plugin docker-commons
2020-04-08 18:17:54.540+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of pipeline-stage-tags-metadata for plugin pipeline-model-definition
2020-04-08 18:17:54.542+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of pipeline-model-declarative-agent for plugin pipeline-model-definition
2020-04-08 18:17:54.545+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of lockable-resources for plugin workflow-aggregator
2020-04-08 18:17:54.547+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of github-api for plugin github-branch-source
2020-04-08 18:17:54.549+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of github for plugin github-branch-source
2020-04-08 18:17:54.550+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of git for plugin github
2020-04-08 18:17:54.554+0000 [id=12]    INFO    hudson.model.UpdateSite$Plugin#deploy: Adding dependent install of mapdb-api for plugin subversion
2020-04-08 18:17:56.404+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading trilead-api
2020-04-08 18:17:58.241+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: trilead-api
2020-04-08 18:17:58.246+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of cloudbees-folder on behalf of admin
2020-04-08 18:18:00.055+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading cloudbees-folder
2020-04-08 18:18:01.331+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: cloudbees-folder
2020-04-08 18:18:01.333+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of antisamy-markup-formatter on behalf of admin
2020-04-08 18:18:02.814+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading antisamy-markup-formatter
2020-04-08 18:18:07.058+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: antisamy-markup-formatter
2020-04-08 18:18:07.137+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of jdk-tool on behalf of admin
2020-04-08 18:18:08.586+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading jdk-tool
2020-04-08 18:18:09.069+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: jdk-tool
2020-04-08 18:18:09.070+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of script-security on behalf of admin
2020-04-08 18:18:10.303+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading script-security
2020-04-08 18:18:14.840+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: script-security
2020-04-08 18:18:14.843+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of command-launcher on behalf of admin
2020-04-08 18:18:16.400+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading command-launcher
2020-04-08 18:18:16.793+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: command-launcher
2020-04-08 18:18:16.832+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of structs on behalf of admin
2020-04-08 18:18:18.242+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading structs
2020-04-08 18:18:18.817+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: structs
2020-04-08 18:18:18.824+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of workflow-step-api on behalf of admin
2020-04-08 18:18:20.210+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading workflow-step-api
2020-04-08 18:18:20.852+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: workflow-step-api
2020-04-08 18:18:20.861+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of token-macro on behalf of admin
2020-04-08 18:18:22.346+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading token-macro
2020-04-08 18:18:26.836+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: token-macro
2020-04-08 18:18:27.039+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of bouncycastle-api on behalf of admin
2020-04-08 18:18:29.110+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading bouncycastle-api
2020-04-08 18:18:39.170+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: bouncycastle-api
2020-04-08 18:18:39.237+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of build-timeout on behalf of admin
2020-04-08 18:18:40.721+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading build-timeout
2020-04-08 18:18:41.378+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: build-timeout
2020-04-08 18:18:41.390+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of credentials on behalf of admin
2020-04-08 18:18:42.664+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading credentials
2020-04-08 18:18:47.472+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: credentials
2020-04-08 18:18:47.474+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of plain-credentials on behalf of admin
2020-04-08 18:18:48.924+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading plain-credentials
2020-04-08 18:18:49.387+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: plain-credentials
2020-04-08 18:18:49.543+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of ssh-credentials on behalf of admin
2020-04-08 18:18:51.076+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading ssh-credentials
2020-04-08 18:18:51.798+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: ssh-credentials
2020-04-08 18:18:51.808+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of credentials-binding on behalf of admin
2020-04-08 18:18:53.047+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading credentials-binding
2020-04-08 18:18:53.931+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: credentials-binding
2020-04-08 18:18:53.933+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of scm-api on behalf of admin
2020-04-08 18:18:55.315+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading scm-api
2020-04-08 18:18:56.526+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: scm-api
2020-04-08 18:18:56.642+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of workflow-api on behalf of admin
2020-04-08 18:18:58.128+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading workflow-api
2020-04-08 18:18:58.956+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: workflow-api
2020-04-08 18:18:58.959+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of timestamper on behalf of admin
2020-04-08 18:19:00.494+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading timestamper
2020-04-08 18:19:02.694+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: timestamper
2020-04-08 18:19:02.699+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of workflow-support on behalf of admin
2020-04-08 18:19:04.137+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading workflow-support
2020-04-08 18:19:05.615+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: workflow-support
2020-04-08 18:19:05.617+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of durable-task on behalf of admin
2020-04-08 18:19:07.011+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading durable-task
2020-04-08 18:19:14.160+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: durable-task
2020-04-08 18:19:14.370+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of workflow-durable-task-step on behalf of admin
2020-04-08 18:19:15.918+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading workflow-durable-task-step
2020-04-08 18:19:16.504+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: workflow-durable-task-step
2020-04-08 18:19:16.509+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of junit on behalf of admin
2020-04-08 18:19:18.062+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading junit
2020-04-08 18:19:19.645+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: junit
2020-04-08 18:19:19.654+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of matrix-project on behalf of admin
2020-04-08 18:19:21.035+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading matrix-project
2020-04-08 18:19:22.430+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: matrix-project
2020-04-08 18:19:22.436+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of resource-disposer on behalf of admin
2020-04-08 18:19:23.770+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading resource-disposer
2020-04-08 18:19:24.229+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: resource-disposer
2020-04-08 18:19:24.491+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of ws-cleanup on behalf of admin
2020-04-08 18:19:25.998+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading ws-cleanup
2020-04-08 18:19:34.398+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: ws-cleanup
2020-04-08 18:19:34.534+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of ant on behalf of admin
2020-04-08 18:19:36.028+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading ant
2020-04-08 18:19:36.639+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: ant
2020-04-08 18:19:36.651+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of ace-editor on behalf of admin
2020-04-08 18:19:38.158+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading ace-editor
2020-04-08 18:19:54.733+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: ace-editor
2020-04-08 18:19:54.736+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of jquery-detached on behalf of admin
2020-04-08 18:19:56.137+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading jquery-detached
2020-04-08 18:19:57.423+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: jquery-detached
2020-04-08 18:19:57.428+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of workflow-scm-step on behalf of admin
2020-04-08 18:19:58.936+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading workflow-scm-step
2020-04-08 18:19:59.329+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: workflow-scm-step
2020-04-08 18:19:59.438+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of workflow-cps on behalf of admin
2020-04-08 18:20:00.723+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading workflow-cps
2020-04-08 18:20:02.170+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: workflow-cps
2020-04-08 18:20:02.174+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of workflow-job on behalf of admin
2020-04-08 18:20:03.618+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading workflow-job
2020-04-08 18:20:04.460+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: workflow-job
2020-04-08 18:20:04.479+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of apache-httpcomponents-client-4-api on behalf of admin

2020-04-08 18:20:05.974+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading apache-httpcomponents-client-4-api
2020-04-08 18:20:10.036+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: apache-httpcomponents-client-4-api
2020-04-08 18:20:10.052+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of display-url-api on behalf of admin
2020-04-08 18:20:11.532+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading display-url-api
2020-04-08 18:20:11.897+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: display-url-api
2020-04-08 18:20:11.985+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of mailer on behalf of admin
2020-04-08 18:20:13.464+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading mailer
2020-04-08 18:20:14.400+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: mailer
2020-04-08 18:20:14.450+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of workflow-basic-steps on behalf of admin
2020-04-08 18:20:15.754+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading workflow-basic-steps
2020-04-08 18:20:16.470+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: workflow-basic-steps
2020-04-08 18:20:16.492+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of gradle on behalf of admin
2020-04-08 18:20:17.693+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading gradle
2020-04-08 18:20:18.334+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: gradle
2020-04-08 18:20:18.982+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of pipeline-milestone-step on behalf of admin
2020-04-08 18:20:20.625+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading pipeline-milestone-step
2020-04-08 18:20:21.022+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: pipeline-milestone-step
2020-04-08 18:20:21.034+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of jackson2-api on behalf of admin
2020-04-08 18:20:22.231+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading jackson2-api
2020-04-08 18:21:22.243+0000 [id=78]    SEVERE  h.model.UpdateCenter$DownloadJob#run: Failed to install jackson2-api
java.net.SocketTimeoutException: Read timed out
        at java.net.SocketInputStream.socketRead0(Native Method)
        at java.net.SocketInputStream.socketRead(SocketInputStream.java:116)
        at java.net.SocketInputStream.read(SocketInputStream.java:171)
        at java.net.SocketInputStream.read(SocketInputStream.java:141)
        at java.io.BufferedInputStream.read1(BufferedInputStream.java:284)
        at java.io.BufferedInputStream.read(BufferedInputStream.java:345)
        at sun.net.www.MeteredStream.read(MeteredStream.java:134)
        at java.io.FilterInputStream.read(FilterInputStream.java:133)
        at sun.net.www.protocol.http.HttpURLConnection$HttpInputStream.read(HttpURLConnection.java:3444)
        at sun.net.www.protocol.http.HttpURLConnection$HttpInputStream.read(HttpURLConnection.java:3437)
        at org.apache.commons.io.input.ProxyInputStream.read(ProxyInputStream.java:78)
        at hudson.model.UpdateCenter$UpdateCenterConfiguration.download(UpdateCenter.java:1245)
Caused: java.io.IOException: Failed to load http://updates.jenkins-ci.org/download/plugins/jackson2-api/2.10.3/jackson2-api.hpi to C:\Users\ragha\.jenkins\plugins\jackson2-api.jpi.tmp
        at hudson.model.UpdateCenter$UpdateCenterConfiguration.download(UpdateCenter.java:1250)
Caused: java.io.IOException: Failed to download from http://updates.jenkins-ci.org/download/plugins/jackson2-api/2.10.3/jackson2-api.hpi (redirected to: http://mirror.serverion.com/jenkins/plugins/jackson2-api/2.10.3/jackson2-api.hpi)
        at hudson.model.UpdateCenter$UpdateCenterConfiguration.download(UpdateCenter.java:1284)
        at hudson.model.UpdateCenter$DownloadJob._run(UpdateCenter.java:1832)
        at hudson.model.UpdateCenter$InstallationJob._run(UpdateCenter.java:2110)
        at hudson.model.UpdateCenter$DownloadJob.run(UpdateCenter.java:1806)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        at hudson.remoting.AtmostOneThreadExecutor$Worker.run(AtmostOneThreadExecutor.java:111)
        at java.lang.Thread.run(Thread.java:748)
2020-04-08 18:21:22.313+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of pipeline-input-step on behalf of admin
2020-04-08 18:21:23.874+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading pipeline-input-step
2020-04-08 18:21:24.194+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: pipeline-input-step
2020-04-08 18:21:24.196+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of pipeline-stage-step on behalf of admin
2020-04-08 18:21:25.411+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading pipeline-stage-step
2020-04-08 18:21:25.868+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: pipeline-stage-step
2020-04-08 18:21:25.901+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of pipeline-graph-analysis on behalf of admin
2020-04-08 18:21:27.455+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading pipeline-graph-analysis
2020-04-08 18:21:28.377+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: pipeline-graph-analysis
2020-04-08 18:21:28.518+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of pipeline-rest-api on behalf of admin
2020-04-08 18:21:29.799+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading pipeline-rest-api
2020-04-08 18:21:30.530+0000 [id=78]    SEVERE  h.model.UpdateCenter$DownloadJob#run: Failed to install pipeline-rest-api
java.io.IOException: Failed to load: Pipeline: REST API Plugin (2.13)
 - Plugin is missing: jackson2-api (2.9.9.1)
        at hudson.PluginWrapper.resolvePluginDependencies(PluginWrapper.java:933)
        at hudson.PluginManager.dynamicLoad(PluginManager.java:929)
Caused: java.io.IOException: Failed to install pipeline-rest-api plugin
        at hudson.PluginManager.dynamicLoad(PluginManager.java:942)
        at hudson.model.UpdateCenter$InstallationJob._run(UpdateCenter.java:2122)
Caused: java.io.IOException: Failed to dynamically deploy this plugin
        at hudson.model.UpdateCenter$InstallationJob._run(UpdateCenter.java:2126)
        at hudson.model.UpdateCenter$DownloadJob.run(UpdateCenter.java:1806)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        at hudson.remoting.AtmostOneThreadExecutor$Worker.run(AtmostOneThreadExecutor.java:111)
        at java.lang.Thread.run(Thread.java:748)
2020-04-08 18:21:30.544+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of handlebars on behalf of admin
2020-04-08 18:21:32.069+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading handlebars
2020-04-08 18:21:32.750+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: handlebars
2020-04-08 18:21:32.752+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of momentjs on behalf of admin
2020-04-08 18:21:34.036+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading momentjs
2020-04-08 18:21:34.438+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: momentjs
2020-04-08 18:21:34.485+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of pipeline-stage-view on behalf of admin
2020-04-08 18:21:35.727+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading pipeline-stage-view
2020-04-08 18:21:37.252+0000 [id=78]    SEVERE  h.model.UpdateCenter$DownloadJob#run: Failed to install pipeline-stage-view
java.io.IOException: Failed to load: Pipeline: Stage View Plugin (2.13)
 - Failed to load: Pipeline: REST API Plugin (2.13)
        at hudson.PluginWrapper.resolvePluginDependencies(PluginWrapper.java:933)
        at hudson.PluginManager.dynamicLoad(PluginManager.java:929)
Caused: java.io.IOException: Failed to install pipeline-stage-view plugin
        at hudson.PluginManager.dynamicLoad(PluginManager.java:942)
        at hudson.model.UpdateCenter$InstallationJob._run(UpdateCenter.java:2122)
Caused: java.io.IOException: Failed to dynamically deploy this plugin
        at hudson.model.UpdateCenter$InstallationJob._run(UpdateCenter.java:2126)
        at hudson.model.UpdateCenter$DownloadJob.run(UpdateCenter.java:1806)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        at hudson.remoting.AtmostOneThreadExecutor$Worker.run(AtmostOneThreadExecutor.java:111)
        at java.lang.Thread.run(Thread.java:748)
2020-04-08 18:21:37.339+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of pipeline-build-step on behalf of admin
2020-04-08 18:21:41.917+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading pipeline-build-step
2020-04-08 18:21:42.305+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: pipeline-build-step
2020-04-08 18:21:42.942+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of pipeline-model-api on behalf of admin
2020-04-08 18:21:59.320+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading pipeline-model-api
2020-04-08 18:22:03.296+0000 [id=78]    SEVERE  h.model.UpdateCenter$DownloadJob#run: Failed to install pipeline-model-api
java.io.IOException: Failed to load: Pipeline: Model API (1.6.0)
 - Plugin is missing: jackson2-api (2.9.8)
        at hudson.PluginWrapper.resolvePluginDependencies(PluginWrapper.java:933)
        at hudson.PluginManager.dynamicLoad(PluginManager.java:929)
Caused: java.io.IOException: Failed to install pipeline-model-api plugin
        at hudson.PluginManager.dynamicLoad(PluginManager.java:942)
        at hudson.model.UpdateCenter$InstallationJob._run(UpdateCenter.java:2122)
Caused: java.io.IOException: Failed to dynamically deploy this plugin
        at hudson.model.UpdateCenter$InstallationJob._run(UpdateCenter.java:2126)
        at hudson.model.UpdateCenter$DownloadJob.run(UpdateCenter.java:1806)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        at hudson.remoting.AtmostOneThreadExecutor$Worker.run(AtmostOneThreadExecutor.java:111)
        at java.lang.Thread.run(Thread.java:748)
2020-04-08 18:22:03.311+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of pipeline-model-extensions on behalf of admin
2020-04-08 18:22:04.914+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading pipeline-model-extensions
2020-04-08 18:22:05.480+0000 [id=78]    SEVERE  h.model.UpdateCenter$DownloadJob#run: Failed to install pipeline-model-extensions
java.io.IOException: Failed to load: Pipeline: Declarative Extension Points API (1.6.0)
 - Failed to load: Pipeline: Model API (1.6.0)
        at hudson.PluginWrapper.resolvePluginDependencies(PluginWrapper.java:933)
        at hudson.PluginManager.dynamicLoad(PluginManager.java:929)
Caused: java.io.IOException: Failed to install pipeline-model-extensions plugin
        at hudson.PluginManager.dynamicLoad(PluginManager.java:942)
        at hudson.model.UpdateCenter$InstallationJob._run(UpdateCenter.java:2122)
Caused: java.io.IOException: Failed to dynamically deploy this plugin
        at hudson.model.UpdateCenter$InstallationJob._run(UpdateCenter.java:2126)
        at hudson.model.UpdateCenter$DownloadJob.run(UpdateCenter.java:1806)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        at hudson.remoting.AtmostOneThreadExecutor$Worker.run(AtmostOneThreadExecutor.java:111)
        at java.lang.Thread.run(Thread.java:748)
2020-04-08 18:22:05.678+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of jsch on behalf of admin
2020-04-08 18:22:07.223+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading jsch
2020-04-08 18:22:08.417+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: jsch
2020-04-08 18:22:08.420+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of git-client on behalf of admin
2020-04-08 18:22:10.120+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading git-client
2020-04-08 18:22:20.822+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: git-client
2020-04-08 18:22:20.856+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of git-server on behalf of admin
2020-04-08 18:22:22.304+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading git-server
2020-04-08 18:22:22.937+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: git-server
2020-04-08 18:22:23.461+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of workflow-cps-global-lib on behalf of admin
2020-04-08 18:22:25.136+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading workflow-cps-global-lib
2020-04-08 18:23:25.814+0000 [id=78]    SEVERE  h.model.UpdateCenter$DownloadJob#run: Failed to install workflow-cps-global-lib
java.net.SocketTimeoutException: Read timed out
        at java.net.SocketInputStream.socketRead0(Native Method)
        at java.net.SocketInputStream.socketRead(SocketInputStream.java:116)
        at java.net.SocketInputStream.read(SocketInputStream.java:171)
        at java.net.SocketInputStream.read(SocketInputStream.java:141)
        at java.io.BufferedInputStream.read1(BufferedInputStream.java:284)
        at java.io.BufferedInputStream.read(BufferedInputStream.java:345)
        at sun.net.www.MeteredStream.read(MeteredStream.java:134)
        at java.io.FilterInputStream.read(FilterInputStream.java:133)
        at sun.net.www.protocol.http.HttpURLConnection$HttpInputStream.read(HttpURLConnection.java:3444)
        at sun.net.www.protocol.http.HttpURLConnection$HttpInputStream.read(HttpURLConnection.java:3437)
        at org.apache.commons.io.input.ProxyInputStream.read(ProxyInputStream.java:78)
        at hudson.model.UpdateCenter$UpdateCenterConfiguration.download(UpdateCenter.java:1245)
Caused: java.io.IOException: Failed to load http://updates.jenkins-ci.org/download/plugins/workflow-cps-global-lib/2.16/workflow-cps-global-lib.hpi to C:\Users\ragha\.jenkins\plugins\workflow-cps-global-lib.jpi.tmp
        at hudson.model.UpdateCenter$UpdateCenterConfiguration.download(UpdateCenter.java:1250)
Caused: java.io.IOException: Failed to download from http://updates.jenkins-ci.org/download/plugins/workflow-cps-global-lib/2.16/workflow-cps-global-lib.hpi (redirected to: http://ftp-nyc.osuosl.org/pub/jenkins/plugins/workflow-cps-global-lib/2.16/workflow-cps-global-lib.hpi)
        at hudson.model.UpdateCenter$UpdateCenterConfiguration.download(UpdateCenter.java:1284)
        at hudson.model.UpdateCenter$DownloadJob._run(UpdateCenter.java:1832)
        at hudson.model.UpdateCenter$InstallationJob._run(UpdateCenter.java:2110)
        at hudson.model.UpdateCenter$DownloadJob.run(UpdateCenter.java:1806)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        at hudson.remoting.AtmostOneThreadExecutor$Worker.run(AtmostOneThreadExecutor.java:111)
        at java.lang.Thread.run(Thread.java:748)
2020-04-08 18:23:25.837+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of branch-api on behalf of admin
2020-04-08 18:23:27.518+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading branch-api
2020-04-08 18:23:28.799+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: branch-api
2020-04-08 18:23:28.821+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of workflow-multibranch on behalf of admin
2020-04-08 18:23:30.622+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading workflow-multibranch
2020-04-08 18:23:31.354+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: workflow-multibranch
2020-04-08 18:23:31.374+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of authentication-tokens on behalf of admin
2020-04-08 18:23:32.707+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading authentication-tokens
2020-04-08 18:23:34.371+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: authentication-tokens
2020-04-08 18:23:35.733+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of docker-commons on behalf of admin
2020-04-08 18:23:37.524+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading docker-commons
2020-04-08 18:23:38.860+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: docker-commons
2020-04-08 18:23:39.039+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of docker-workflow on behalf of admin
2020-04-08 18:23:40.319+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading docker-workflow
2020-04-08 18:23:41.929+0000 [id=78]    SEVERE  h.model.UpdateCenter$DownloadJob#run: Failed to install docker-workflow
java.io.IOException: Failed to load: Docker Pipeline (1.23)
 - Failed to load: Pipeline: Declarative Extension Points API (1.6.0)
        at hudson.PluginWrapper.resolvePluginDependencies(PluginWrapper.java:933)
        at hudson.PluginManager.dynamicLoad(PluginManager.java:929)
Caused: java.io.IOException: Failed to install docker-workflow plugin
        at hudson.PluginManager.dynamicLoad(PluginManager.java:942)
        at hudson.model.UpdateCenter$InstallationJob._run(UpdateCenter.java:2122)
Caused: java.io.IOException: Failed to dynamically deploy this plugin
        at hudson.model.UpdateCenter$InstallationJob._run(UpdateCenter.java:2126)
        at hudson.model.UpdateCenter$DownloadJob.run(UpdateCenter.java:1806)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        at hudson.remoting.AtmostOneThreadExecutor$Worker.run(AtmostOneThreadExecutor.java:111)
        at java.lang.Thread.run(Thread.java:748)
2020-04-08 18:23:42.262+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of pipeline-stage-tags-metadata on behalf of admin
2020-04-08 18:23:43.789+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading pipeline-stage-tags-metadata
2020-04-08 18:23:43.976+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: pipeline-stage-tags-metadata
2020-04-08 18:23:43.977+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of pipeline-model-declarative-agent on behalf of admin
2020-04-08 18:23:45.208+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading pipeline-model-declarative-agent
2020-04-08 18:23:45.407+0000 [id=78]    SEVERE  h.model.UpdateCenter$DownloadJob#run: Failed to install pipeline-model-declarative-agent
java.io.IOException: Failed to load: Pipeline: Declarative Agent API (1.1.1)
 - Failed to load: Pipeline: Declarative Extension Points API (1.6.0)
        at hudson.PluginWrapper.resolvePluginDependencies(PluginWrapper.java:933)
        at hudson.PluginManager.dynamicLoad(PluginManager.java:929)
Caused: java.io.IOException: Failed to install pipeline-model-declarative-agent plugin
        at hudson.PluginManager.dynamicLoad(PluginManager.java:942)
        at hudson.model.UpdateCenter$InstallationJob._run(UpdateCenter.java:2122)
Caused: java.io.IOException: Failed to dynamically deploy this plugin
        at hudson.model.UpdateCenter$InstallationJob._run(UpdateCenter.java:2126)
        at hudson.model.UpdateCenter$DownloadJob.run(UpdateCenter.java:1806)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        at hudson.remoting.AtmostOneThreadExecutor$Worker.run(AtmostOneThreadExecutor.java:111)
        at java.lang.Thread.run(Thread.java:748)
2020-04-08 18:23:45.428+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of pipeline-model-definition on behalf of admin
2020-04-08 18:23:46.613+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading pipeline-model-definition
2020-04-08 18:23:50.595+0000 [id=78]    SEVERE  h.model.UpdateCenter$DownloadJob#run: Failed to install pipeline-model-definition
java.io.IOException: Failed to load: Pipeline: Declarative (1.6.0)
 - Failed to load: Docker Pipeline (1.23)
 - Plugin is missing: workflow-cps-global-lib (2.9)
        at hudson.PluginWrapper.resolvePluginDependencies(PluginWrapper.java:933)
        at hudson.PluginManager.dynamicLoad(PluginManager.java:929)
Caused: java.io.IOException: Failed to install pipeline-model-definition plugin
        at hudson.PluginManager.dynamicLoad(PluginManager.java:942)
        at hudson.model.UpdateCenter$InstallationJob._run(UpdateCenter.java:2122)
Caused: java.io.IOException: Failed to dynamically deploy this plugin
        at hudson.model.UpdateCenter$InstallationJob._run(UpdateCenter.java:2126)
        at hudson.model.UpdateCenter$DownloadJob.run(UpdateCenter.java:1806)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        at hudson.remoting.AtmostOneThreadExecutor$Worker.run(AtmostOneThreadExecutor.java:111)
        at java.lang.Thread.run(Thread.java:748)
2020-04-08 18:23:51.943+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of lockable-resources on behalf of admin
2020-04-08 18:23:53.509+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading lockable-resources
2020-04-08 18:23:54.632+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: lockable-resources
2020-04-08 18:23:55.479+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of workflow-aggregator on behalf of admin
2020-04-08 18:23:57.880+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading workflow-aggregator
2020-04-08 18:23:58.442+0000 [id=78]    SEVERE  h.model.UpdateCenter$DownloadJob#run: Failed to install workflow-aggregator
java.io.IOException: Failed to load: Pipeline (2.6)
 - Failed to load: Pipeline: Stage View Plugin (2.13)
        at hudson.PluginWrapper.resolvePluginDependencies(PluginWrapper.java:933)
        at hudson.PluginManager.dynamicLoad(PluginManager.java:929)
Caused: java.io.IOException: Failed to install workflow-aggregator plugin
        at hudson.PluginManager.dynamicLoad(PluginManager.java:942)
        at hudson.model.UpdateCenter$InstallationJob._run(UpdateCenter.java:2122)
Caused: java.io.IOException: Failed to dynamically deploy this plugin
        at hudson.model.UpdateCenter$InstallationJob._run(UpdateCenter.java:2126)
        at hudson.model.UpdateCenter$DownloadJob.run(UpdateCenter.java:1806)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        at hudson.remoting.AtmostOneThreadExecutor$Worker.run(AtmostOneThreadExecutor.java:111)
        at java.lang.Thread.run(Thread.java:748)
2020-04-08 18:23:58.532+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of github-api on behalf of admin
2020-04-08 18:24:00.279+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading github-api
2020-04-08 18:24:02.899+0000 [id=78]    SEVERE  h.model.UpdateCenter$DownloadJob#run: Failed to install github-api
java.io.IOException: Failed to load: GitHub API Plugin (1.110)
 - Plugin is missing: jackson2-api (2.10.2)
        at hudson.PluginWrapper.resolvePluginDependencies(PluginWrapper.java:933)
        at hudson.PluginManager.dynamicLoad(PluginManager.java:929)
Caused: java.io.IOException: Failed to install github-api plugin
        at hudson.PluginManager.dynamicLoad(PluginManager.java:942)
        at hudson.model.UpdateCenter$InstallationJob._run(UpdateCenter.java:2122)
Caused: java.io.IOException: Failed to dynamically deploy this plugin
        at hudson.model.UpdateCenter$InstallationJob._run(UpdateCenter.java:2126)
        at hudson.model.UpdateCenter$DownloadJob.run(UpdateCenter.java:1806)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        at hudson.remoting.AtmostOneThreadExecutor$Worker.run(AtmostOneThreadExecutor.java:111)
        at java.lang.Thread.run(Thread.java:748)
2020-04-08 18:24:03.071+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of git on behalf of admin
2020-04-08 18:24:04.638+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading git
2020-04-08 18:24:07.103+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: git
2020-04-08 18:24:07.104+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of github on behalf of admin
2020-04-08 18:24:08.628+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading github
2020-04-08 18:24:51.033+0000 [id=78]    SEVERE  h.model.UpdateCenter$DownloadJob#run: Failed to install github
java.net.SocketException: Connection reset
        at java.net.SocketInputStream.read(SocketInputStream.java:210)
        at java.net.SocketInputStream.read(SocketInputStream.java:141)
        at java.io.BufferedInputStream.read1(BufferedInputStream.java:284)
        at java.io.BufferedInputStream.read(BufferedInputStream.java:345)
        at sun.net.www.MeteredStream.read(MeteredStream.java:134)
        at java.io.FilterInputStream.read(FilterInputStream.java:133)
        at sun.net.www.protocol.http.HttpURLConnection$HttpInputStream.read(HttpURLConnection.java:3444)
        at sun.net.www.protocol.http.HttpURLConnection$HttpInputStream.read(HttpURLConnection.java:3437)
        at org.apache.commons.io.input.ProxyInputStream.read(ProxyInputStream.java:78)
        at hudson.model.UpdateCenter$UpdateCenterConfiguration.download(UpdateCenter.java:1245)
Caused: java.io.IOException: Failed to load http://updates.jenkins-ci.org/download/plugins/github/1.29.5/github.hpi to C:\Users\ragha\.jenkins\plugins\github.jpi.tmp
        at hudson.model.UpdateCenter$UpdateCenterConfiguration.download(UpdateCenter.java:1250)
Caused: java.io.IOException: Failed to download from http://updates.jenkins-ci.org/download/plugins/github/1.29.5/github.hpi (redirected to: http://ftp-chi.osuosl.org/pub/jenkins/plugins/github/1.29.5/github.hpi)
        at hudson.model.UpdateCenter$UpdateCenterConfiguration.download(UpdateCenter.java:1284)
        at hudson.model.UpdateCenter$DownloadJob._run(UpdateCenter.java:1832)
        at hudson.model.UpdateCenter$InstallationJob._run(UpdateCenter.java:2110)
        at hudson.model.UpdateCenter$DownloadJob.run(UpdateCenter.java:1806)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        at hudson.remoting.AtmostOneThreadExecutor$Worker.run(AtmostOneThreadExecutor.java:111)
        at java.lang.Thread.run(Thread.java:748)
2020-04-08 18:24:51.208+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of github-branch-source on behalf of admin
2020-04-08 18:24:52.723+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading github-branch-source
2020-04-08 18:24:53.991+0000 [id=78]    SEVERE  h.model.UpdateCenter$DownloadJob#run: Failed to install github-branch-source
java.io.IOException: Failed to load: GitHub Branch Source Plugin (2.6.0)
 - Plugin is missing: github (1.29.3)
 - Failed to load: GitHub API Plugin (1.110)
        at hudson.PluginWrapper.resolvePluginDependencies(PluginWrapper.java:933)
        at hudson.PluginManager.dynamicLoad(PluginManager.java:929)
Caused: java.io.IOException: Failed to install github-branch-source plugin
        at hudson.PluginManager.dynamicLoad(PluginManager.java:942)
        at hudson.model.UpdateCenter$InstallationJob._run(UpdateCenter.java:2122)
Caused: java.io.IOException: Failed to dynamically deploy this plugin
        at hudson.model.UpdateCenter$InstallationJob._run(UpdateCenter.java:2126)
        at hudson.model.UpdateCenter$DownloadJob.run(UpdateCenter.java:1806)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        at hudson.remoting.AtmostOneThreadExecutor$Worker.run(AtmostOneThreadExecutor.java:111)
        at java.lang.Thread.run(Thread.java:748)
2020-04-08 18:24:54.011+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of pipeline-github-lib on behalf of admin
2020-04-08 18:24:55.491+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading pipeline-github-lib
2020-04-08 18:24:55.778+0000 [id=78]    SEVERE  h.model.UpdateCenter$DownloadJob#run: Failed to install pipeline-github-lib
java.io.IOException: Failed to load: Pipeline: GitHub Groovy Libraries (1.0)
 - Plugin is missing: workflow-cps-global-lib (2.5)
        at hudson.PluginWrapper.resolvePluginDependencies(PluginWrapper.java:933)
        at hudson.PluginManager.dynamicLoad(PluginManager.java:929)
Caused: java.io.IOException: Failed to install pipeline-github-lib plugin
        at hudson.PluginManager.dynamicLoad(PluginManager.java:942)
        at hudson.model.UpdateCenter$InstallationJob._run(UpdateCenter.java:2122)
Caused: java.io.IOException: Failed to dynamically deploy this plugin
        at hudson.model.UpdateCenter$InstallationJob._run(UpdateCenter.java:2126)
        at hudson.model.UpdateCenter$DownloadJob.run(UpdateCenter.java:1806)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        at hudson.remoting.AtmostOneThreadExecutor$Worker.run(AtmostOneThreadExecutor.java:111)
        at java.lang.Thread.run(Thread.java:748)
2020-04-08 18:24:55.844+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of pipeline-stage-view on behalf of admin
2020-04-08 18:24:57.369+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading pipeline-stage-view
2020-04-08 18:25:00.062+0000 [id=78]    SEVERE  h.model.UpdateCenter$DownloadJob#run: Failed to install pipeline-stage-view
Also:           Also:   java.nio.file.FileSystemException: C:\Users\ragha\.jenkins\plugins\pipeline-stage-view\WEB-INF\lib\pipeline-stage-view.jar: The process cannot access the file because it is being used by another process.

                        at sun.nio.fs.WindowsException.translateToIOException(WindowsException.java:86)
                        at sun.nio.fs.WindowsException.rethrowAsIOException(WindowsException.java:97)
                        at sun.nio.fs.WindowsException.rethrowAsIOException(WindowsException.java:102)
                        at sun.nio.fs.WindowsFileSystemProvider.implDelete(WindowsFileSystemProvider.java:269)
                        at sun.nio.fs.AbstractFileSystemProvider.deleteIfExists(AbstractFileSystemProvider.java:108)
                        at java.nio.file.Files.deleteIfExists(Files.java:1165)
                        at jenkins.util.io.PathRemover.removeOrMakeRemovableThenRemove(PathRemover.java:237)
        Also:   java.nio.file.FileSystemException: C:\Users\ragha\.jenkins\plugins\pipeline-stage-view\WEB-INF\lib\pipeline-stage-view.jar: The process cannot access the file because it is being used by another process.

                        at sun.nio.fs.WindowsException.translateToIOException(WindowsException.java:86)
                        at sun.nio.fs.WindowsException.rethrowAsIOException(WindowsException.java:97)
                        at sun.nio.fs.WindowsException.rethrowAsIOException(WindowsException.java:102)
                        at sun.nio.fs.WindowsFileSystemProvider.implDelete(WindowsFileSystemProvider.java:269)
                        at sun.nio.fs.AbstractFileSystemProvider.deleteIfExists(AbstractFileSystemProvider.java:108)
                        at java.nio.file.Files.deleteIfExists(Files.java:1165)
                        at jenkins.util.io.PathRemover.removeOrMakeRemovableThenRemove(PathRemover.java:241)
jenkins.util.io.CompositeIOException: Unable to remove file C:\Users\ragha\.jenkins\plugins\pipeline-stage-view\WEB-INF\lib\pipeline-stage-view.jar
                at jenkins.util.io.PathRemover.removeOrMakeRemovableThenRemove(PathRemover.java:252)
                at jenkins.util.io.PathRemover.tryRemoveFile(PathRemover.java:205)
                at jenkins.util.io.PathRemover.tryRemoveRecursive(PathRemover.java:216)
                at jenkins.util.io.PathRemover.tryRemoveDirectoryContents(PathRemover.java:226)
                at jenkins.util.io.PathRemover.tryRemoveRecursive(PathRemover.java:215)
                at jenkins.util.io.PathRemover.tryRemoveDirectoryContents(PathRemover.java:226)
                at jenkins.util.io.PathRemover.tryRemoveRecursive(PathRemover.java:215)
                at jenkins.util.io.PathRemover.tryRemoveDirectoryContents(PathRemover.java:226)
                at jenkins.util.io.PathRemover.tryRemoveRecursive(PathRemover.java:215)
                at jenkins.util.io.PathRemover.forceRemoveRecursive(PathRemover.java:96)
Also:           Also:   java.nio.file.DirectoryNotEmptyException: C:\Users\ragha\.jenkins\plugins\pipeline-stage-view\WEB-INF\lib
                        at sun.nio.fs.WindowsFileSystemProvider.implDelete(WindowsFileSystemProvider.java:266)
                        at sun.nio.fs.AbstractFileSystemProvider.deleteIfExists(AbstractFileSystemProvider.java:108)
                        at java.nio.file.Files.deleteIfExists(Files.java:1165)
                        at jenkins.util.io.PathRemover.removeOrMakeRemovableThenRemove(PathRemover.java:237)
        Also:   java.nio.file.DirectoryNotEmptyException: C:\Users\ragha\.jenkins\plugins\pipeline-stage-view\WEB-INF\lib
                        at sun.nio.fs.WindowsFileSystemProvider.implDelete(WindowsFileSystemProvider.java:266)
                        at sun.nio.fs.AbstractFileSystemProvider.deleteIfExists(AbstractFileSystemProvider.java:108)
                        at java.nio.file.Files.deleteIfExists(Files.java:1165)
                        at jenkins.util.io.PathRemover.removeOrMakeRemovableThenRemove(PathRemover.java:241)
jenkins.util.io.CompositeIOException: Unable to remove directory C:\Users\ragha\.jenkins\plugins\pipeline-stage-view\WEB-INF\lib with directory contents: [C:\Users\ragha\.jenkins\plugins\pipeline-stage-view\WEB-INF\lib\pipeline-stage-view.jar]
                at jenkins.util.io.PathRemover.removeOrMakeRemovableThenRemove(PathRemover.java:250)
                at jenkins.util.io.PathRemover.tryRemoveFile(PathRemover.java:205)
                at jenkins.util.io.PathRemover.tryRemoveRecursive(PathRemover.java:216)
                at jenkins.util.io.PathRemover.tryRemoveDirectoryContents(PathRemover.java:226)
                at jenkins.util.io.PathRemover.tryRemoveRecursive(PathRemover.java:215)
                at jenkins.util.io.PathRemover.tryRemoveDirectoryContents(PathRemover.java:226)
                at jenkins.util.io.PathRemover.tryRemoveRecursive(PathRemover.java:215)
                at jenkins.util.io.PathRemover.forceRemoveRecursive(PathRemover.java:96)
Also:           Also:   java.nio.file.DirectoryNotEmptyException: C:\Users\ragha\.jenkins\plugins\pipeline-stage-view\WEB-INF
                        at sun.nio.fs.WindowsFileSystemProvider.implDelete(WindowsFileSystemProvider.java:266)
                        at sun.nio.fs.AbstractFileSystemProvider.deleteIfExists(AbstractFileSystemProvider.java:108)
                        at java.nio.file.Files.deleteIfExists(Files.java:1165)
                        at jenkins.util.io.PathRemover.removeOrMakeRemovableThenRemove(PathRemover.java:237)
        Also:   java.nio.file.DirectoryNotEmptyException: C:\Users\ragha\.jenkins\plugins\pipeline-stage-view\WEB-INF
                        at sun.nio.fs.WindowsFileSystemProvider.implDelete(WindowsFileSystemProvider.java:266)
                        at sun.nio.fs.AbstractFileSystemProvider.deleteIfExists(AbstractFileSystemProvider.java:108)
                        at java.nio.file.Files.deleteIfExists(Files.java:1165)
                        at jenkins.util.io.PathRemover.removeOrMakeRemovableThenRemove(PathRemover.java:241)
jenkins.util.io.CompositeIOException: Unable to remove directory C:\Users\ragha\.jenkins\plugins\pipeline-stage-view\WEB-INF with directory contents: [C:\Users\ragha\.jenkins\plugins\pipeline-stage-view\WEB-INF\lib]
                at jenkins.util.io.PathRemover.removeOrMakeRemovableThenRemove(PathRemover.java:250)
                at jenkins.util.io.PathRemover.tryRemoveFile(PathRemover.java:205)
                at jenkins.util.io.PathRemover.tryRemoveRecursive(PathRemover.java:216)
                at jenkins.util.io.PathRemover.tryRemoveDirectoryContents(PathRemover.java:226)
                at jenkins.util.io.PathRemover.tryRemoveRecursive(PathRemover.java:215)
                at jenkins.util.io.PathRemover.forceRemoveRecursive(PathRemover.java:96)
Also:           Also:   java.nio.file.DirectoryNotEmptyException: C:\Users\ragha\.jenkins\plugins\pipeline-stage-view
                        at sun.nio.fs.WindowsFileSystemProvider.implDelete(WindowsFileSystemProvider.java:266)
                        at sun.nio.fs.AbstractFileSystemProvider.deleteIfExists(AbstractFileSystemProvider.java:108)
                        at java.nio.file.Files.deleteIfExists(Files.java:1165)
                        at jenkins.util.io.PathRemover.removeOrMakeRemovableThenRemove(PathRemover.java:237)
        Also:   java.nio.file.DirectoryNotEmptyException: C:\Users\ragha\.jenkins\plugins\pipeline-stage-view
                        at sun.nio.fs.WindowsFileSystemProvider.implDelete(WindowsFileSystemProvider.java:266)
                        at sun.nio.fs.AbstractFileSystemProvider.deleteIfExists(AbstractFileSystemProvider.java:108)
                        at java.nio.file.Files.deleteIfExists(Files.java:1165)
                        at jenkins.util.io.PathRemover.removeOrMakeRemovableThenRemove(PathRemover.java:241)
jenkins.util.io.CompositeIOException: Unable to remove directory C:\Users\ragha\.jenkins\plugins\pipeline-stage-view with directory contents: [C:\Users\ragha\.jenkins\plugins\pipeline-stage-view\WEB-INF]
                at jenkins.util.io.PathRemover.removeOrMakeRemovableThenRemove(PathRemover.java:250)
                at jenkins.util.io.PathRemover.tryRemoveFile(PathRemover.java:205)
                at jenkins.util.io.PathRemover.tryRemoveRecursive(PathRemover.java:216)
                at jenkins.util.io.PathRemover.forceRemoveRecursive(PathRemover.java:96)
jenkins.util.io.CompositeIOException: Unable to delete 'C:\Users\ragha\.jenkins\plugins\pipeline-stage-view'. Tried 3 times (of a maximum of 3) waiting 0.1 sec between attempts.
        at jenkins.util.io.PathRemover.forceRemoveRecursive(PathRemover.java:99)
        at hudson.Util.deleteRecursive(Util.java:294)
        at hudson.Util.deleteRecursive(Util.java:283)
        at hudson.ClassicPluginStrategy.explode(ClassicPluginStrategy.java:477)
        at hudson.ClassicPluginStrategy.createPluginWrapper(ClassicPluginStrategy.java:175)
        at hudson.PluginManager.dynamicLoad(PluginManager.java:910)
        at hudson.model.UpdateCenter$InstallationJob._run(UpdateCenter.java:2122)
Caused: java.io.IOException: Failed to dynamically deploy this plugin
        at hudson.model.UpdateCenter$InstallationJob._run(UpdateCenter.java:2126)
        at hudson.model.UpdateCenter$DownloadJob.run(UpdateCenter.java:1806)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        at hudson.remoting.AtmostOneThreadExecutor$Worker.run(AtmostOneThreadExecutor.java:111)
        at java.lang.Thread.run(Thread.java:748)
2020-04-08 18:25:01.393+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of git on behalf of admin
2020-04-08 18:25:01.398+0000 [id=78]    INFO    h.m.UpdateCenter$InstallationJob#_run: Skipping duplicate install of: Git@4.2.2
2020-04-08 18:25:01.405+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: git
2020-04-08 18:25:01.406+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of mapdb-api on behalf of admin
2020-04-08 18:25:02.820+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading mapdb-api
2020-04-08 18:25:04.296+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: mapdb-api
2020-04-08 18:25:04.324+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of subversion on behalf of admin
2020-04-08 18:25:06.053+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading subversion
2020-04-08 18:25:11.730+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: subversion
2020-04-08 18:25:11.732+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of ssh-slaves on behalf of admin
2020-04-08 18:25:13.294+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading ssh-slaves
2020-04-08 18:25:14.487+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: ssh-slaves
2020-04-08 18:25:14.489+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of matrix-auth on behalf of admin
2020-04-08 18:25:15.896+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading matrix-auth
2020-04-08 18:25:16.835+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: matrix-auth
2020-04-08 18:25:16.900+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of pam-auth on behalf of admin
2020-04-08 18:25:18.375+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading pam-auth
2020-04-08 18:25:21.919+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: pam-auth
2020-04-08 18:25:21.921+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of ldap on behalf of admin
2020-04-08 18:25:23.546+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading ldap
2020-04-08 18:25:24.335+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: ldap
2020-04-08 18:25:24.336+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of email-ext on behalf of admin
2020-04-08 18:25:25.724+0000 [id=78]    INFO    h.m.UpdateCenter$UpdateCenterConfiguration#download: Downloading email-ext
2020-04-08 18:25:31.116+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: email-ext
2020-04-08 18:25:31.117+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Starting the installation of mailer on behalf of admin
2020-04-08 18:25:31.118+0000 [id=78]    INFO    h.m.UpdateCenter$InstallationJob#_run: Skipping duplicate install of: Mailer@1.31
2020-04-08 18:25:31.120+0000 [id=78]    INFO    h.model.UpdateCenter$DownloadJob#run: Installation successful: mailer
2020-04-08 18:25:31.122+0000 [id=78]    INFO    h.m.UpdateCenter$CompleteBatchJob#run: Completing installing of plugin batchà
2020-04-08 18:25:53.814+0000 [id=78]    INFO    h.m.DownloadService$Downloadable#load: Obtained the updated data file for hudson.tools.JDKInstaller
2020-04-08 18:25:54.218+0000 [id=78]    INFO    h.ExtensionFinder$GuiceFinder$FaultTolerantScope$1#error: Failed to instantiate optional component hudson.plugins.build_timeout.operations.AbortAndRestartOperation$DescriptorImpl; skipping
2020-04-08 18:25:55.380+0000 [id=78]    INFO    h.m.DownloadService$Downloadable#load: Obtained the updated data file for hudson.tasks.Ant.AntInstaller
2020-04-08 18:25:56.621+0000 [id=78]    INFO    h.m.DownloadService$Downloadable#load: Obtained the updated data file for hudson.plugins.gradle.GradleInstaller
2020-04-08 18:25:59.052+0000 [id=78]    INFO    h.ExtensionFinder$GuiceFinder$FaultTolerantScope$1#error: Failed to instantiate optional component hudson.plugins.build_timeout.operations.AbortAndRestartOperation$DescriptorImpl; skipping
2020-04-08 18:25:59.092+0000 [id=78]    INFO    h.ExtensionFinder$GuiceFinder$FaultTolerantScope$1#error: Failed to instantiate optional component hudson.plugins.build_timeout.operations.AbortAndRestartOperation$DescriptorImpl; skipping
2020-04-08 18:25:59.192+0000 [id=78]    INFO    h.ExtensionFinder$GuiceFinder$FaultTolerantScope$1#error: Failed to instantiate optional component hudson.plugins.build_timeout.operations.AbortAndRestartOperation$DescriptorImpl; skipping
2020-04-08 18:25:59.216+0000 [id=78]    INFO    h.ExtensionFinder$GuiceFinder$FaultTolerantScope$1#error: Failed to instantiate optional component hudson.plugins.build_timeout.operations.AbortAndRestartOperation$DescriptorImpl; skipping
2020-04-08 18:25:59.254+0000 [id=78]    INFO    h.ExtensionFinder$GuiceFinder$FaultTolerantScope$1#error: Failed to instantiate optional component hudson.plugins.build_timeout.operations.AbortAndRestartOperation$DescriptorImpl; skipping
2020-04-08 18:25:59.509+0000 [id=95]    INFO    jenkins.InitReactorRunner$1#onAttained: Started initialization
2020-04-08 18:25:59.518+0000 [id=99]    INFO    jenkins.InitReactorRunner$1#onAttained: Listed all plugins
2020-04-08 18:25:59.520+0000 [id=99]    INFO    jenkins.InitReactorRunner$1#onAttained: Prepared all plugins
2020-04-08 18:25:59.536+0000 [id=99]    INFO    jenkins.InitReactorRunner$1#onAttained: Started all plugins
2020-04-08 18:25:59.631+0000 [id=101]   INFO    jenkins.InitReactorRunner$1#onAttained: Augmented all extensions
2020-04-08 18:25:59.638+0000 [id=100]   INFO    jenkins.InitReactorRunner$1#onAttained: System config loaded
2020-04-08 18:25:59.647+0000 [id=100]   INFO    jenkins.InitReactorRunner$1#onAttained: System config adapted
2020-04-08 18:25:59.753+0000 [id=99]    INFO    jenkins.InitReactorRunner$1#onAttained: Loaded all jobs
2020-04-08 18:25:59.754+0000 [id=96]    INFO    jenkins.InitReactorRunner$1#onAttained: Configuration for all jobs updated
2020-04-08 18:25:59.785+0000 [id=101]   INFO    jenkins.InitReactorRunner$1#onAttained: Completed initialization
2020-04-08 18:25:59.788+0000 [id=78]    INFO    h.m.UpdateCenter$CompleteBatchJob#run: Completed installation of 60 plugins in 8 min 5 sec
```
