# DevOps

SET09803 DevOps module — Edinburgh Napier University


![GitHub commit activity (branch)](https://img.shields.io/github/commit-activity/w/40857078/Devops/main)
[![GitHub Actions](https://github.com/40857078/Devops/actions/workflows/main.yml/badge.svg?branch=main)](https://github.com/40857078/Devops/actions/workflows/main.yml)
[![Qodana](https://img.shields.io/badge/code%20quality-qodana-blue)](https://github.com/40857078/Devops/blob/main/qodana.yaml)
![Releases](https://img.shields.io/github/release/40857078/Devops/all.svg?style=flat-square)

## Salary report by role

Run the application with `salary-by-role` followed by a job title. With Docker Compose, for example:

```sh
docker compose run --rm app salary-by-role Engineer
```

If no title is provided, the application prompts for one. The report includes employees with current titles and salaries, ordered by employee number. Set `DB_URL`, `DB_USER`, and `DB_PASSWORD` to use a different MySQL connection. The Compose service uses the bundled `employees` database.

