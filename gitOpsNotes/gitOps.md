# GitOps


## Topics

 * What is
 * Where to use it
 * When to use it
 * Pros
 * Arcitecture
 
## What is Git Ops 

GitOps is an operational framework that takes DevOps best practices used for application development such as version control, collaboration, compliance, and CI/CD, and applies them to infrastructure automation. Being an evolution of IaC (Infrastructure As Code), it is a modern concept that was initially introduced by the Kubernetes management system Weaveworks. 

While the traditional approaches to maintain an Infrastructure demanded a runbook to manage the steps, GitOps is the full operations lifecycle of infrastructure management, living as a code in a git repository. This model uses Git, an open source, distributed version control system, to track any changes to a system and who has made them. 

The GitOps model uses a Git repository as the single source of truth (SSoT), improving collaboration between developers and operational team members. This, in turn, allows organizations to automate the deployment process. 

With GitOps, the desired state of a system, including infrastructure, application code, and configurations, is defined in a Git repository. Changes to the system are made by committing and merging code changes in the Git repository, which triggers automated processes to reconcile the desired state with the actual state of the system. Continuous Integration and Continuous Deployment (CI/CD) pipelines are often used to automate the process of synchronizing the system with the desired state defined in the Git repository. By leveraging CI/CD pipelines like DevOps, changes are automatically applied to the codebase without any need for manual input. Thanks to Git, these changes can also be easily reversed if needed, reverting to a previous working version. 


### How it is different from Dev Ops 

We must be very clear on the similar buzzword - called Dev Ops, and how the Git Ops differs from the term Dev Ops - which has been in existence for more than a decade now, and that is a defacto standard in any Software Development in the Enterprises of any size (small, medium or big).

DevOps is a set of practices that combines software development (Dev) and IT operations (Ops) to improve collaboration, communication, and efficiency in the software delivery process. It focuses on breaking down silos between development and operations teams, promoting automation, continuous integration, and continuous deployment.

GitOps, on the other hand, is a specific methodology within the broader DevOps framework. It introduces the concept of using Git as the single source of truth for managing infrastructure, application code, and configurations. While DevOps encompasses a wide range of practices and principles, GitOps focuses specifically on the declarative and automated management of systems using Git as the central hub.

In summary, GitOps is a specific methodology within the DevOps space that leverages Git as the central source of truth for managing system configurations, while DevOps is a broader set of practices and principles that aims to improve collaboration and efficiency in the software delivery process. Additionally, GitOps is typically used in conjunction with containerization technologies like Kubernetes, while DevOps can be used with any type of application.

> GitOps is not a replacement for DevOps, as the CI process still relies on DevOps tools. However, GitOps can improve the effectiveness of the DevOps team thanks to continuous delivery processes. 

### Shoudl we use GitOps only for the Infrastructure Automation? 

Though most part, GitOps was perceived and conceptualized to be used for the Infrastucture Automation, it can however be used for managing both application deployments and base infrastructure made up of systems needed regardless of the applications deployed (i.e. networking, security, etc.). Both will follow the same procedures to plan, review, approve and release code into production. 

Done right, GitOps will let engineers constantly apply updates to infrastructure meet all the needs of the applications in a continuous delivery format. The version control system ensures everything is recorded and visible and an audit trail keeps teams compliant. GitOps will make it easy to revert problematic changes, becoming a single source of truth about what is happening in the system from both the software development and infrastructure perspective.

## Where to use it 

You can use Git Ops in the following scenarios and environments, where a declarative source of truth is efficient, simple and seamless.

  Cloud-native Applications: For managing deployments of containerized applications in Kubernetes or similar container orchestration platforms, GitOps provides a streamlined approach for managing the desired state of the applications.

  Microservices Architecture: Typically, in a microservices architecture, we need multiple services need to be deployed and coordinated. GitOps allows for centralized control and consistency while enabling independent deployment of individual services.

   Multi-Environment Deployments:  In an enterprise dealing with several different environments - like Development (DEV), Staging (QA), UAT, and Production (PROD), GitOps provides a unified approach for managing deployments across these environments. With GitOps, you can define and manage the desired state of each environment in a centralized Git repository, whereby avoiding the hassles of doing things manually based on enviroments.

   Infrastructure as Code (IaC): GitOps complements infrastructure as code (IaC) practices, making it easier to manage and version infrastructure configurations alongside application deployments. It brings consistency and reproducibility to infrastructure management.

   Team Collaboration: Since all changes are version-controlled in the Git repository, it becomes easier to review, track, and collaborate on deployments. Different team members can work together on the same codebase and contribute to the desired state.

   Continuous Integration/Continuous Deployment (CI/CD): GitOps integrates well with CI/CD pipelines, enabling continuous deployment practices. By triggering deployments based on changes pushed to the Git repository, it automates the deployment process and allows for rapid and frequent releases.

   Compliance and Auditing: GitOps provides an auditable and traceable deployment process. As all changes are made through code commits, it becomes easier to track and audit the modifications made to the infrastructure and applications. This is particularly beneficial for organizations with compliance requirements.

## When to use it

You can favor Git Ops in any enterprise that prefers the following - where each of them are self explanatory.

* IaC - Infrastructure as a Code
* Consitency and Reproducability
* Self Documenting Deployments - GitOps allows you to manage deployments completely from inside your environment without having a need to share the credentials with the peers.
* Auditable and Traceable
* Continous Deployment
* Collaborative Deployment
* Rollbacks and Roll-forwards - easy to navigate (switch) to any stage of the infrastructure as every snapshot is recorded in a version control system.
* Shared Knowledge in Teams, by avoiding the unwanted dependency on the individuals.

## Architecture 

GitOps ensures that a system’s cloud infrastructure is immediately reproducible based on the state of a Git repository. Pull requests modify the state of the Git repository. Once approved and merged, the pull requests will automatically reconfigure and sync the live infrastructure to the state of the repository. This live syncing pull request workflow is the core essence of GitOps.

The Architecture of Git Ops consists of the following key four components/steps. 

    * Set up a Git repository for your organization’s codebase. It need not be always GitHub, but any client that is Git compataible will do the job.
    * Connect this repository to a CI/CD tool.
    * Configure the tools like Jenkins, Circle CI etc., to deploy automatic changes to your development environment.
    * Set up monitoring and alerts for your development environment. 

It should be noted that the CI part of GitOps still needs to go through your DevOps tool, whether it’s GitHub Actions or AWS CodeBuild. 

The architecture follows a pull-based model, where the GitOps operator continuously pulls the desired state from the Git repository and takes actions to align the system with that state. Any changes made to the system are done through code changes committed to the Git repository, triggering the GitOps process to update the system accordingly.

Overall, the architecture of GitOps combines the declarative nature of Git repositories with automation and continuous integration to provide a consistent, auditable, and reproducible approach to managing infrastructure and application changes.

## Pros 

With the advent of automating the Infrastructure management, GitOps offers an improved efficiency and security, a better developer experience, reduced costs, and faster deployments.

Using a version control system lets a team track all modifications to the configuration of a system. This gives a “source of truth” and valuable audit trail to review if something breaks or behaves unexpectedly. Teams can review the GitOps history and see when a regression was introduced. Additionally this audit trail can be used as a reference for compliance or security auditing. The GitOps history can be used as proof when things like encryption certificates are modified or updated.

With GitOps, organizations can manage their entire infrastructure and application development lifecycle using a single, unified tool. This allows for greater collaboration and coordination between teams and results in fewer errors and faster problem resolution.

In addition, GitOps can help organizations take advantage of containers and microservices and maintain consistency across all their infrastructure — from Kubernetes cluster configurations and Docker images to cloud instances and anything on-prem.

## Cons

Like every other tool/technology, GitOps also has certain limitations, which we should be aware of and better prepared to tackle it. 

Though GitOps embraces DevOps, it has its own learning curve on the tools and concepts plus the best practices, and the complexity if not properly attended to. On a large scale enterprises dealing with intricate architectures or complex environments, a well thought through and carefully reviewed and maintained roadmap, CI/CD pipeline is very essential for a successful Infra Automation. 

Eventhough GitOps is centrally running around Git, maintaining a proper version history is essential to avoid the version conflicts, which might impact the availability of the applications if not properly tracked and handled. Another subtle point to note is that Git always demands the connectivity to the repository, and any outage will cause the unavailability of environments and/or the applications, as GitOps was not perceived with a completely offline execution. 


## References 

* https://about.gitlab.com/topics/gitops/
* https://www.gitops.tech/
* https://www.atlassian.com/git/tutorials/gitops
* https://www.redhat.com/en/topics/devops/what-is-gitops
* https://devops.com/an-inside-look-at-gitops/
* https://devops.com/the-differences-between-devops-and-gitops/