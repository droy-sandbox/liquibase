package liquibase.integrationtest.command


import liquibase.change.ColumnConfig
import liquibase.change.core.CreateTableChange
import liquibase.integrationtest.setup.SetupDatabaseStructure

import static liquibase.integrationtest.command.CommandTest.commandTests
import static liquibase.integrationtest.command.CommandTest.run

commandTests(
        run {
            command "dropAll"

            setup new SetupDatabaseStructure([
                    [
                            new CreateTableChange(
                                    tableName: "FirstTable",
                                    columns: [
                                            ColumnConfig.fromName("FirstColumn")
                                                    .setType("VARCHAR(255)")
                                    ]
                            )
                    ] as SetupDatabaseStructure.Entry,
                    [
                            new CreateTableChange(
                                    tableName: "SecondTable",
                                    columns: [
                                            ColumnConfig.fromName("SecondColumn")
                                                    .setType("VARCHAR(255)")
                                    ]
                            )
                    ] as SetupDatabaseStructure.Entry
            ])

            expectedOutput ""

            expectedResults([
                    statusCode: 0
            ])
        }
)
