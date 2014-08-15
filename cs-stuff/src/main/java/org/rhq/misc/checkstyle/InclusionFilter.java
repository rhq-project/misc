package org.rhq.misc.checkstyle;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import com.puppycrawl.tools.checkstyle.api.AuditEvent;
import com.puppycrawl.tools.checkstyle.api.AutomaticBean;
import com.puppycrawl.tools.checkstyle.api.Filter;
import com.puppycrawl.tools.checkstyle.api.Utils;

/**
 * Inclusion Filter for checkstyle
 * Follows the example from http://checkstyle.sourceforge.net/writingfilters.html
 */
@SuppressWarnings("unused")
public class InclusionFilter extends AutomaticBean implements Filter {


    private Pattern mFileRegexp;

    public InclusionFilter()
        throws PatternSyntaxException
    {
        setFiles("^$");
    }

    public boolean accept(AuditEvent aEvent)
    {
        final String fileName = aEvent.getFileName();
        boolean matches = (fileName != null) && mFileRegexp.matcher(fileName).find();
        return matches;
    }

    public void setFiles(String aFilesPattern)
        throws PatternSyntaxException
    {
        mFileRegexp = Utils.getPattern(aFilesPattern);
    }
}

