import Message from "../utils/Message.svelte";
import { render } from "@testing-library/svelte";

describe("Error component", () => {
  const text = "Page not found";
  test("should render correctly", () => {
    render(Message, { props: {message: text} });
    const h2 = document.querySelector("h2").innerHTML;
    expect(h2).toEqual(text);
  });
});
