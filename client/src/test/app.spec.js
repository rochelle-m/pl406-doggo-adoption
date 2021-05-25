import App from "../App.svelte";
import { render } from "@testing-library/svelte";

describe("Main app component", () => {
  test("should render component correctly", () => {
    const { container } = render(App);
    expect(container).toContainHTML("<body></body>");
  });
});
