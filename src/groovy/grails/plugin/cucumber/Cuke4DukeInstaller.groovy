/*
 * Copyright 2011 Martin Hauner
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package grails.plugin.cucumber


class Cuke4DukeInstaller {
    JRubyRunner runner
    Folder home
    JGem gem

	Cuke4DukeInstaller (JRubyRunner runner, Folder home, JGem gem) {
        this.runner = runner
        this.home = home
        this.gem = gem
    }

    void run () {
        runner.run { jruby ->
            jruby.setArgv ([
                "install",
                "cuke4duke",
                "--version",
                "0.4.4",            // todo: get from config...
                "--install-dir",
                home.path ()
            ] as String[])

            jruby.runScriptlet (gem.reader (), gem.name ())
        }
    }
}