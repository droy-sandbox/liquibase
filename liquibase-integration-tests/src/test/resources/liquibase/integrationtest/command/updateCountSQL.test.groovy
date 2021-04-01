package liquibase.integrationtest.command


import liquibase.integrationtest.setup.SetupDatabaseChangeLog

import static liquibase.integrationtest.command.CommandTest.commandTests
import static liquibase.integrationtest.command.CommandTest.run

commandTests(
        run {
            command "updateCountSQL"

            setup new SetupDatabaseChangeLog("changelogs/hsqldb/complete/simple.changelog.xml")

            arguments([
                    count: 1
            ])

            expectedOutput ""

            expectedResults([
                    statusMessage: "Successfully executed updateCountSQL",
                    statusCode   : 0
            ])
        }
)
