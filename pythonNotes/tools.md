# Python Tools

## Jupyter

 * Open Source tool used as an interactive Python Shell/Interpreter on the web browser
 * Comes preshipped with *Anaconda*
 * By default runs on the port `8888`. However it can be customized using the `jupyter_notebook_config.py` file.
 * If you dont have the config file in the `C:\users\<userName>\.jupyter` directory, create on on the `Anaconda Shell` as follows. 
 ```
 (base) PS C:\Users\ragha> jupyter notebook --generate-config
 Writing default config to: C:\Users\ragha\.jupyter\jupyter_notebook_config.py
 ```
 * For opening the jupyter notebook, you can do it in two ways.
   * Click on 'Jupyter Notebook' Launch on the *`Anaconda Navigator`*
   * Click on the *`Anaconda Powershell Prompt`* and then type `jupyter notebook`. 
 * For customizing the port number, edit the following line in the `jupyter_notebook_config.py` file as follows. *Note* By default all entries are commented with a `#` key on the first letter of each line.
 ```
 ## The port the notebook server will listen on.
 #c.NotebookApp.port = 8888
 c.NotebookApp.port = 9999
 ```
 * The jupyter notebook command has the following log in the `Anaconda Power Shell`.
 ```
 (base) PS C:\Users\ragha> jupyter notebook
[I 23:35:51.249 NotebookApp] JupyterLab extension loaded from C:\installedSoft\Anaconda3\lib\site-packages\jupyterlab
[I 23:35:51.250 NotebookApp] JupyterLab application directory is C:\installedSoft\Anaconda3\share\jupyter\lab
[I 23:35:52.717 NotebookApp] Serving notebooks from local directory: C:\Users\ragha
[I 23:35:52.717 NotebookApp] The Jupyter Notebook is running at:
[I 23:35:52.722 NotebookApp] http://localhost:9999/?token=33bc81d20689bfc7d9d99320c537f503c5c02e92180ad36a
[I 23:35:52.722 NotebookApp]  or http://127.0.0.1:9999/?token=33bc81d20689bfc7d9d99320c537f503c5c02e92180ad36a
[I 23:35:52.727 NotebookApp] Use Control-C to stop this server and shut down all kernels (twice to skip confirmation).
[C 23:35:53.423 NotebookApp]

    To access the notebook, open this file in a browser:
        file:///C:/Users/ragha/AppData/Roaming/jupyter/runtime/nbserver-28320-open.html
    Or copy and paste one of these URLs:
        http://localhost:9999/?token=33bc81d20689bfc7d9d99320c537f503c5c02e92180ad36a
     or http://127.0.0.1:9999/?token=33bc81d20689bfc7d9d99320c537f503c5c02e92180ad36a
 ```

