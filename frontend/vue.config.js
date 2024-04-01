const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  outputDir: '../src/main/resources/static', // Build Driectory
    devServer: {
      proxy: 'http://localhost:8888' // Spring Boot Server
    }
})
