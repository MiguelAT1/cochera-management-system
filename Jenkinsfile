pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven3'
    }

    stages {
        stage('Clonar repositorio') {
            steps {
                echo 'Código obtenido desde el repositorio remoto.'
            }
        }

        stage('Compilar backend') {
            steps {
                dir('backend') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage('Ejecutar pruebas') {
            steps {
                dir('backend') {
                    sh 'mvn test'
                }
            }
        }

        stage('Empaquetar') {
            steps {
                dir('backend') {
                    sh 'mvn package -DskipTests'
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline ejecutado correctamente.'
        }
        failure {
            echo 'El pipeline falló. Revisar errores antes de hacer merge.'
        }
    }
}
