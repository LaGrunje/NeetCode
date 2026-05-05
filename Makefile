.PHONY: help solve-kotlin solve-cpp solve list

CATEGORY ?= arrays_and_hashing
PROBLEM  ?= contains_duplicate

help:
	@echo "Usage:"
	@echo "  make solve-kotlin PROBLEM=two-sum"
	@echo "  make solve-cpp    PROBLEM=two-sum"
	@echo "  make solve        PROBLEM=two-sum   # оба языка"
	@echo "  make solve-all                       # все задачи"
	@echo "  make list                            # список задач"

solve-kotlin:
	./gradlew :problems:$(CATEGORY):$(PROBLEM):solveKotlin

solve-cpp:
	./gradlew :problems:$(CATEGORY):$(PROBLEM):solveCpp

solve:
	./gradlew :problems:$(CATEGORY):$(PROBLEM):solve

solve-all:
	./gradlew solveAll

test-kotlin:
	./gradlew :problems:$(CATEGORY):$(PROBLEM):test

test-cpp:
	./gradlew :problems:$(CATEGORY):$(PROBLEM):testCpp

list:
	@find problems -mindepth 2 -maxdepth 2 -type d | sort