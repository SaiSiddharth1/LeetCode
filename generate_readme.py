import os
import re
import requests
from collections import defaultdict

LEETCODE_API = "https://leetcode.com/graphql"

QUERY = """
query getQuestionDetail($titleSlug: String!) {
  question(titleSlug: $titleSlug) {
    questionId
    title
    titleSlug
    difficulty
    topicTags {
      name
    }
  }
}
"""

def get_slug(folder_name):
    match = re.match(r"^\d+-(.+)$", folder_name)
    if match:
        return match.group(1)
    return None

def get_problem(slug):
    response = requests.post(
        LEETCODE_API,
        json={
            "query": QUERY,
            "variables": {"titleSlug": slug}
        },
        timeout=10
    )
    data = response.json()
    return data.get("data", {}).get("question")

def main():
    topics = defaultdict(list)
    total = 0

    for folder in os.listdir("."):
        if not os.path.isdir(folder):
            continue

        slug = get_slug(folder)
        if not slug:
            continue

        problem = get_problem(slug)
        if not problem:
            print(f"Skipped: {folder}")
            continue

        total += 1

        for tag in problem["topicTags"]:
            topics[tag["name"]].append(problem | {"folder": folder})

    with open("README.md", "w", encoding="utf-8") as f:
        f.write("# LeetCode Solutions\n\n")
        f.write(f"Total Problems Solved: **{total}**\n\n")
        f.write("## Topics\n\n")

        for topic in sorted(topics):
            f.write(f"### {topic}\n\n")
            f.write("| # | Problem | Difficulty |\n")
            f.write("|---|---------|------------|\n")

            problems = sorted(topics[topic], key=lambda p: int(p["questionId"]))

            for p in problems:
                difficulty = p["difficulty"]
                folder = p["folder"]
                title = p["title"]
                qid = p["questionId"]

                f.write(
                    f"| {qid} | [{title}](./{folder}) | {difficulty} |\n"
                )

            f.write("\n")

    print("README.md generated successfully!")

if __name__ == "__main__":
    main()
