package org.apache.jasper.tagplugins.jstl.core;

import org.apache.jasper.compiler.tagplugin.TagPlugin;
import org.apache.jasper.compiler.tagplugin.TagPluginContext;
import org.apache.jasper.tagplugins.jstl.Util;

public class Remove implements TagPlugin {

    @Override
    public void doTag(TagPluginContext ctxt) {

        //scope flag
        boolean hasScope = ctxt.isAttributeSpecified("scope");

        //the value of the "var"
        String strVar = ctxt.getConstantAttribute("var");

        //remove attribute from certain scope.
        //default scope is "page".
        if (hasScope) {
            int iScope = Util.getScope(ctxt.getConstantAttribute("scope"));
            ctxt.generateJavaSource("pageContext.removeAttribute(\"" + strVar + "\"," + iScope + ");");
        } else {
            ctxt.generateJavaSource("pageContext.removeAttribute(\"" + strVar + "\");");
        }
    }

}
