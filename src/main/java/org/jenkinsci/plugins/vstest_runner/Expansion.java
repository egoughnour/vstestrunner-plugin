package org.jenkinsci.plugins.vstest_runner;

import java.io.IOException;

import org.jenkinsci.plugins.tokenmacro.MacroEvaluationException;
import org.jenkinsci.plugins.tokenmacro.TokenMacro;

import hudson.EnvVars;
import hudson.FilePath;
import hudson.Util;
import hudson.model.Run;
import hudson.model.TaskListener;

public class Expansion 
{
	public boolean error;
	public String value;
	
	
	public Expansion(boolean error)
	{
		this.error = error;
	}
	
	public Expansion(BuildParameters params)
	{
		tryReplaceMacro(params.toExpand, params.env, params.build, params.path, params.listener);
	}
	
	/**
    *
    * @param value
    * @param env
    * @param build
    * @param workspace
    * @return
    */
   private void tryReplaceMacro(String value, EnvVars env, Run<?, ?> build, FilePath path, TaskListener listener) {
       String result = Util.replaceMacro(value, env);
       try {
    	   this.value = TokenMacro.expandAll(build, path, listener, result).trim();
    	   error = false;
    	   return;
       }catch(MacroEvaluationException e)
       {
    	  listener.error(e.getMessage()); 
       } catch (IOException e) {
    	   listener.error(e.getMessage());
       } catch (InterruptedException e) {
		listener.error(e.getMessage());
       }
       error = true;
   }
}
