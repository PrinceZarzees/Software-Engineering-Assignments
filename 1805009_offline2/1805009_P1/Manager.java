class Manager {
    SystemBuilder builder;

    public void build(SystemBuilder obj) {
        builder = obj;
        obj.BuildSystem();
    }

}