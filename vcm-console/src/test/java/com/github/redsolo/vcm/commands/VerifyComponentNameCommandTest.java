package com.github.redsolo.vcm.commands;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.io.File;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.github.redsolo.vcm.commands.MainConfiguration;
import com.github.redsolo.vcm.commands.VerifyComponentNameCommand;
import com.github.redsolo.vcm.util.TestUtil;

public class VerifyComponentNameCommandTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void assertProperty() throws Throwable {
        File file = TestUtil.getResourceFile(folder.getRoot());
        
        VerifyComponentNameCommand command = new VerifyComponentNameCommand();
        command.setComponentRootPath(file.getParentFile().getCanonicalPath());
        int value = command.execute(new MainConfiguration());
        
        assertThat(value, is(not(0)));
    }
}
