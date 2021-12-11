/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2021 Andre White.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.swagger.v3.plugins.grudle.petstore;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.ServerVariable;
import io.swagger.v3.oas.annotations.tags.Tag;

@OpenAPIDefinition(
    info = @Info(
        title = "the title",
        version = "0.0",
        description = "My API",
        license = @License(name = "Apache 2.0", url = "http://foo.bar"),
        contact = @Contact(url = "http://gigantic-server.com", name = "Fred", email = "Fred@gigagantic-server.com")
    ),
    tags = {
        @Tag(name = "Tag 1", description = "desc 1", externalDocs = @ExternalDocumentation(description = "docs desc")),
        @Tag(name = "Tag 2", description = "desc 2", externalDocs = @ExternalDocumentation(description = "docs desc 2")),
        @Tag(name = "Tag 3")
    },
    externalDocs = @ExternalDocumentation(description = "definition docs desc"),
    security = {
        @SecurityRequirement(name = "req 1", scopes = {"a", "b"}),
        @SecurityRequirement(name = "req 2", scopes = {"b", "c"})
    },
    servers = {
        @Server(
            description = "server 1",
            url = "http://foo",
            variables = {
                @ServerVariable(name = "var1", description = "var 1", defaultValue = "1", allowableValues = {"1", "2"}),
                @ServerVariable(name = "var2", description = "var 2", defaultValue = "1", allowableValues = {"1", "2"})
            })
    }
)
public class ApiInfo {
}