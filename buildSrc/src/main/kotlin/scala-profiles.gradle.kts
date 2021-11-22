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
plugins {
    id("scala-conventions")
    id("org.scoverage")
}


scoverage {
    val cfgs = listOf(Pair(org.scoverage.CoverageType.Branch, 0.2.toBigDecimal()),
        Pair(org.scoverage.CoverageType.Statement, 0.75.toBigDecimal()))
    val cks = cfgs.map { (k, v) ->
        val b = org.scoverage.ScoverageExtension.CheckConfig()
        b.minimumRate = v
        b.coverageType = k
        b
    }
    checks.addAll(cks)
}
