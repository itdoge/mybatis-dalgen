package com.dalgen.mybatis;

import org.apache.maven.project.MavenProject;
import org.mockito.Mockito;

import com.dalgen.mybatis.utils.CmdUtil;
import com.dalgen.mybatis.utils.ConfigUtil;

/**
 * Created by bangis.wangdf on 15/12/5.
 * Desc
 */
public class DalgenMojoTest extends BaseTest {

    public void testExecute() throws Exception {
        MavenProject project = new MavenProject();
        project.setName("");
        // 输出目录 /Users/huangyan/IdeaProject3/mybatis-dalgen/target/classes/out
        // 模板目录 /Users/huangyan/IdeaProject3/mybatis-dalgen/target/classes/dalgen/templates
        // 配置文件 /Users/huangyan/IdeaProject3/mybatis-dalgen/target/classes/dalgen/config/config.xml
        // 创建DalgenMojo对象
        DalgenMojo dalgenMojo = new DalgenMojo(outputDirectory,templateDirectory,config,project,true);
        // mock出CmdUtils对象
        CmdUtil cmdUtil = Mockito.mock(CmdUtil.class);
        Mockito.when(cmdUtil.consoleInput()).thenReturn(ConfigUtil.getCmd());
        dalgenMojo.setCmdUtil(cmdUtil);

        dalgenMojo.execute();
    }
}