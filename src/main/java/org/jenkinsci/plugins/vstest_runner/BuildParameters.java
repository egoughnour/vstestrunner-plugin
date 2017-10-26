package org.jenkinsci.plugins.vstest_runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hudson.EnvVars;
import hudson.FilePath;
import hudson.Launcher;
import hudson.model.Run;
import hudson.model.TaskListener;

public class BuildParameters 
{
	public String toExpand;
	public EnvVars env;
	public Run<?, ?> build;
	public FilePath path;
	public TaskListener listener;
	public Launcher launcher;
	
	public boolean hasLauncher()
	{
		return null != launcher;
	}

	public BuildParameters(String toExpand, EnvVars env, Run<?, ?> build, FilePath path, TaskListener listener)
	{
		this.toExpand = toExpand;
		this.env = env;
		this.build = build;
		this.path = path;
		this.listener = listener;
		
	}
	
	public BuildParameters(String toExpand, EnvVars env, Run<?, ?> build, FilePath path, TaskListener listener, Launcher launcher)
	{	
		this(toExpand, env, build, path, listener);
	
		this.launcher = launcher;
	}
	
	public Expansion replaceMacro(String valueToExpand)
	{
		String current = this.toExpand;
		this.toExpand = valueToExpand;
		Expansion result = new Expansion(this);
		this.toExpand = current;
		return result;
	}
	
	public String[] expandFileSet(String pattern) {
        List<String> fileNames = new ArrayList<String>();
        try {
        for (FilePath x: path.list(pattern))
            fileNames.add(x.getRemote());
        } catch (IOException ioe) {}
        catch (InterruptedException inte) {}
        return fileNames.toArray(new String[fileNames.size()]);
    }

}