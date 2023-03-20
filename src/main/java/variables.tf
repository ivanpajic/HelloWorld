variable "code" {
    type = object({
        name          = string
        version       = string
        directory     = string
        build_command = optional(string)
        built_to      = optional(string)
    })
}

variable "lambda" {
    type = object({
        description   = optional(string)
        role_arn      = string
        handler       = optional(string)
        memory_size   = optional(number)
        timeout       = optional(number)
        runtime       = optional(string)
        architectures = optional(list(string))
        layers        = optional(list(string))
        env_vars      = optional(map(any))
        log_retention = optional(number)
    })
}

variable "iam" {
    type = object({
        principal  = optional(string)
        source_arn = string
    })
}
module "event_bridge_callbacks" {
    source = "../../modules/aws/lambda/nodejs-function"
}
