# spring-boot-kms

Setup 

~/.aws> vim .\config
[default]
region=ap-south-1
output=json

[aws-kms-user]
region=ap-south-1
output=json

Setup ~/.aws> vim .\config
.aws> vim .\credentials

[default]
aws_access_key_id = your_aws_access_key_id
aws_secret_access_key = your_aws_secret_access_key

[aws-kms-user]
aws_access_key_id = your_aws_access_key_id
aws_secret_access_key = your_aws_secret_access_key


aws kms generate-data-key --key-id alias/demo --key-spec AES_256 --profile aws-kms-user --region ap-south-1
