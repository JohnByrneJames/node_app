# Instructions of how to setup a CICD End-to-End Pipeline.

By the end of this guide you will be able to integrate, deliver and deploy code to a docker image on the docker hub. **This guide requires access to AWS**.

### Pre-Requisites
1. **3** EC2 (_Elastic Compute Cloud_) instances on AWS.
	* **1**: Jenkins-Master instance.
	* **2**: Jenkins-Slave instance.
	* **3**: Docker Production instance.