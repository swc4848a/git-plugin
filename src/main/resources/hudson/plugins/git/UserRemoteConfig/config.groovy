package hudson.plugins.git.UserRemoteConfig;

f = namespace(lib.FormTagLib)

f.entry(title:_("Repository URL"), field:"url") {
    f.textbox()
}

f.entry(title:_("Credentials"), field:"credentialsId") {
    f.select(onchange="""{
            var self = this.targetElement ? this.targetElement : this;
            var r = findPreviousFormItem(self,'url');
            r.onchange(r);
            self = null;
            r = null;
    }""" /* workaround for JENKINS-19124 */)
}

f.advanced {
    f.entry(title:_("Name"), field:"name") {
        f.textbox()
    }
    f.entry(title:_("Refspec"), field:"refspec") {
        f.textbox()
    }
}

f.entry {
    div(align:"right") {
        input (type:"button", value:_("Add Repository"), class:"repeatable-add show-if-last")
        input (type:"button", value:_("Delete Repository"), class:"repeatable-delete")
    }
}
