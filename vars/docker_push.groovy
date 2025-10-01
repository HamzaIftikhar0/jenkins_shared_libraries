def call(String project, String imageTag, String dockerHubUser) {
    withCredentials([usernamePassword(
        credentialsId: 'dockerHubCred',
        passwordVariable: 'dockerHubPass',
        usernameVariable: 'dockerHubUser'
    )]) {
        sh """
            echo "$dockerHubPass" | docker login -u "$dockerHubUser" --password-stdin
            docker push ${dockerHubUser}/${project}:${imageTag}
        """
    }
}
