/**
* Configuration for UI library paths and settings
* Controls whether to use local or CDN versions of libraries
*/
const LibConfig = {
    // Set to true to use local libraries, false for CDN versions
    useLocalLibs: true,

    // Library paths configuration
    paths: {
        bootstrap: {
            local: {
                css: '/lib/css/bootstrap.min.css',
                js: '/lib/js/bootstrap.bundle.min.js'
            },
            cdn: {
                css: 'https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css',
                js: 'https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js'
            }
        },
        bootstrapIcons: {
            local: {
                css: '/lib/css/bootstrap-icons.css'
            },
            cdn: {
                css: 'https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css'
            }
        },
        highlightjs: {
            local: {
                css: '/lib/css/highlight.min.css',
                js: '/lib/js/highlight.min.js'
            },
            cdn: {
                css: 'https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.8.0/styles/default.min.css',
                js: 'https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.8.0/highlight.min.js'
            }
        }
    },

    /**
    * Get the path for a specific library resource
    * @param {string} library - The library name (e.g., 'bootstrap', 'bootstrapIcons')
    * @param {string} type - The resource type ('css' or 'js')
    * @returns {string} The path to the resource
    */
    getPath: function(library, type) {
        const source = this.useLocalLibs ? 'local' : 'cdn';
        return this.paths[library][source][type];
    },

    /**
    * Toggle between local and CDN versions
    * @param {boolean} useLocal - Whether to use local versions
    */
    setUseLocal: function(useLocal) {
        this.useLocalLibs = useLocal;
    }
};

// Export for use in other modules
if (typeof module !== 'undefined' && module.exports) {
    module.exports = LibConfig;
}

