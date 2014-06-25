/*
 * Copyright 2014 Rik van der Kleij

 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.powertuple.intellij.haskell;

import com.intellij.lang.Language;

public class HaskellLanguage extends Language {
    public static final HaskellLanguage INSTANCE = new HaskellLanguage();

    public HaskellLanguage() {
        super("Haskell");
    }

    @Override
    public String getDisplayName() {
        return "Haskell language";
    }

    @Override
    public boolean isCaseSensitive() {
        return true;
    }
}
