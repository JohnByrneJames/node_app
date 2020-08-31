pipeline {
	environment {
		registry = "johnbyrnejames/nodeapp_prod_ready"
		registryCredentials = 'DockerHub'
	}
	agent slaveprod
	stages {
		stage('Pull Image') {
			steps {
				docker.withRegistry( '', registryCredentials) {
					dockerImage.pull()
				}
			}
		}
		stage('Run Container') {
			steps {
				//
			}
		}
		stage('Deploy new Changes') {
			steps {
				//
			}
		}
	}
}