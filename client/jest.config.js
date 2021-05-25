module.exports = {
  transform: {
    "^.+\\.svelte$": "svelte-jester",
    "^.+\\.js$": "babel-jest",
  },
  transformIgnorePatterns: ["!node_modules/"],
  moduleFileExtensions: ["js", "svelte"],
  setupFiles: ["./scripts/setupTests.js"],
  testPathIgnorePatterns: ["node_modules"],
  bail: false,
  verbose: true,
  setupFilesAfterEnv: ["@testing-library/jest-dom/extend-expect"],
  globals: {
    __DEV__: true,
  },
};
