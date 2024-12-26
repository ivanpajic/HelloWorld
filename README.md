<div align="center"><img height="180" src="https://gitlab.iscpif.fr/gargantext/main/raw/master/images/logo.png"></div>

&nbsp;
# Gargantext with Haskell (Backend instance)

![Haskell](https://img.shields.io/badge/Code-Haskell-informational?style=flat&logo=haskell&color=6144b3)&nbsp;&nbsp;![Nix](https://img.shields.io/badge/Package%20manager-Nix-informational?style=flat&logo=nixos&color=6586c8)&nbsp;&nbsp;![Cabal](https://img.shields.io/badge/Tools-Cabal-informational?style=flat&logo=cabal&color=567dd9)&nbsp;&nbsp;![Stack](https://img.shields.io/badge/Tools-Stack-informational?style=flat&logo=stack&color=6144b3)&nbsp;&nbsp;![GHC](https://img.shields.io/badge/Tools-GHC-informational?style=flat&logo=&color=2E677B)&nbsp;&nbsp;![Docker](https://img.shields.io/badge/Tools-Docker-informational?style=flat&logo=docker&color=003f8c)

#### Table of Contents
1. [About the project](#about)
2. [Installation](#install)
3. [Use cases](#use-cases)
4. [Notes for developers](#develop)
5. [`haskell-language-server`](#haskell-language-server)
6. [Running the tests](#running-tests)
7. [Async workers](#async-workers)
8. [Notifications](#notifications)

## About the project <a name="about"></a>

GarganText is a collaborative web-decentralized-based macro-service platform for the exploration of unstructured texts. It combines tools from natural language processing, text-data-mining bricks, complex networks analysis algorithms and interactive data visualization tools to pave the way toward new kinds of interactions with your textual and digital corpora.

This software is free (as "Libre" in French) software, developed by the CNRS Complex Systems Institute of Paris Île-de-France (ISC-PIF) and its partners.

GarganText Project: this repo builds the backend for the frontend server built by [backend](https://gitlab.iscpif.fr/gargantext/haskell-gargantext).


## Installation <a name="install"></a>

Disclaimer: since this project is still in development, this document remains in progress. Please report and improve this documentation if you encounter any issues.

### Prerequisites

You need to have the following installed:
* [GHCup](https://www.haskell.org/ghcup/)
* [Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
* [Nix](https://nixos.org/download/)
* [Docker Compose](https://docs.docker.com/compose/install/).

You will need to add yourself as a member of the `docker` group for Docker
Compose to work (replace `myusername` with your username in the following
command):
```bash
sudo usermod -a -G docker myusername
```

### Getting the source code

```bash
git clone https://gitlab.iscpif.fr/gargantext/haskell-gargantext.git
cd haskell-gargantext
git clone https://gitlab.iscpif.fr/gargantext/haskell-gargantext.git
cd ..
```

### Building Gargantext

#### Building the Backend

Run the install script from inside the `haskell-gargantext/` directory:
```bash
./bin/install
```
This will build Gargantext, run the tests, and build the documentation.

#### Building the Frontend

Move into the `purescript-gargantext/` directory, then run the install script:
```bash
cd purescript-gargantext
./bin/install
cd ..
```

### Initialization

Rename the `gargantext-settings.toml_toModify` into `gargantext-settings.toml`,
and fill in the missing fields.

> `.gitignore` excludes this file, so you don't need to worry about committing
> it by mistake, and you can change the passwords in `gargantext-settings.toml`
> safely.

**NOTE** If you had the `gargantext.ini` file before, you can automatically
convert it into a file `gargantext-settings.toml` by running the following
from a Nix shell:
```shell
n$ ./bin/cli ini
```

### Launching and Initializing the Database

Launch the docker image from inside the dedicated directory:
```bash
cd devops/docker/
docker compose up
```

Then initialize the database using the dedicated command: from inside the
`haskell-gargantext/` directory, run
```bash
./bin/cli init
```

And provide a name and a password for the master user as requested.

### Running Gargantext

From inside the `haskell-gargantext/` directory, run
```bash
./bin/run
```

## Use Cases <a name="use-cases"></a>

### Multi-User with Graphical User Interface (Server Mode)

``` shell
$ cabal v2-run gargantext -- server start -m Prod
```

Then you can log in with `user1` / `1resu`

To start server and all workers:
```shell
$ cabal v2-run gargantext -- server start-all -m Prod
```

### Command Line Mode tools

#### Simple cooccurrences computation and indexation from a list of Ngrams

``` shell
$ cabal v2-run gargantext -- filter-terms CorpusFromGarg.csv ListFromGarg.csv Ouput.json
```

### Analyzing the ngrams table repo

We store the repository in directory `repos` in the [CBOR](https://cbor.io/) file format. To decode it to JSON and analyze, say, using [jq](https://shapeshed.com/jq-json/), use the following command:

``` shell
$ cat repos/repo.cbor.v5 | stack exec gargantext-cbor2json | jq .
```
### Documentation

To build documentation, run:

```shell
$ stack build --haddock --no-haddock-deps --fast
```

(in `.stack-work/dist/x86_64-linux-nix/Cabal-3.2.1.0/doc/html/gargantext`).


## Notes for developers <a name="develop"></a>

### Developer Documentation

If you want to contribute to Gargantext, there is [some documentation geared to developers](https://write.frame.gargantext.org/s/805e1ee2bae24079554d24cdbc8ef5ba5c4ef7d83218c1e86c84af8ac269031d).

### Upgrading Haskell Packages

We use `gargantext.cabal`, `cabal.project` and `cabal.project.freeze`
as the source of truth. Ouf ot that, we generate the `stack.yaml` file
for those who prefer to use Stack.

Upgrading packages can be a pain sometimes, with cabal.

Here are some tips:

- Manually remove entries from your `cabal.project.freeze` to make the
  build a bit more "elastic";
- Lock the hackage-index state in the `cabal.project`, so that the
  solver won't try to pull newer dependencies;
- Specify constraints you want directly when building like `cabal
  v2-build --constraint tasty==x.y.z.w`
- Generate another `.freeze` with `cabal v2-freeze` once you got the
  new build to compile (this is good for small, incremental upgrades)
- Bounds in `.cabal` are definitely respected, but ofc the `.freeze`
  takes priority, so you want to maybe use `cabal gen-bounds` when
  your `.freeze` still exists, remove the file, try again.

Also, it's helpful to build with `stack build` from time to time. The
warnings are displayed, whenever a different stack lts package is used
than the one defined in `.cabal` file - it's an incentive to upgrade
the `.cabal` file versions.

Occasionally, you can get issues with the `allow-newer: *` constraint
from `cabal.project`. E.g. when I was building with GHC 9.4.7, I had
errors with `hashable-1.5.0`. The solution is:
```shell
cabal v2-build --constraint hashable==1.4.3.0
```
(we don't depend on `hashable` directly, but `allow-newer: *` is so
liberal that a package that is too new is used).

Overall, it's preferred to specify strict constraints in
`gargantext.cabal` file and to do that, one can use `stack ls dependencies`
to have an idea what works.

If you want to see the detailed build info for a given dependency:
```shell
cabal v2-build -v servant-server
```

Also, you might use the `-Wunused-packages` GHC option, to get a
warning about unused packages (make sure though you build all targets
with `cabal v2-build all`).

Also, here is a relevant discussion:
https://discourse.haskell.org/t/whats-your-workflow-to-update-cabal-dependencies/9475

### Running Tests

From nix shell:

```shell
n$ cabal v2-test --test-show-details=streaming
```

Or, from "outside":
```shell
$ nix-shell --run "cabal v2-test --test-show-details=streaming"
```

If you want to run particular tests, use (for Tasty):
```shell
cabal v2-test garg-test-tasty --test-show-details=streaming --test-option=--pattern='/job status update and tracking/
```
or (for Hspec):
```shell
cabal v2-test garg-test-hspec --test-show-details=streaming --test-option=--match='/Dispatcher, Central Exchange, WebSockets/'
```

### CI

The CI is on gitlab and is controlled by the `.gitlab-ci.yml` file.

The Docker image that is used can be built with:
```shell
podman build -t cgenie/gargantext:9.4.8 -f ./devops/docker/Dockerfile --format=docker .
```
or
```shell
docker build -t cgenie/gargantext:9.4.8 -f ./devops/docker/Dockerfile .
```

NOTE: if podman/docker complains about not enough space, it's probably
about tmpfs. In that case you can set
```shell
mkdir _build
export TMPDIR=$(pwd)/_build
```
(https://stackoverflow.com/questions/75845647/changing-podman-build-to-path-with-more-space).

### Working on libraries

When a development is needed on libraries (for instance, the HAL crawler in https://gitlab.iscpif.fr/gargantext/crawlers):

1. Ongoing devlopment (on local repo):
   1. In `cabal.project`:
      - add `../hal` to `packages:`
      - turn off (temporarily) the `hal` in `source-repository-package` 
   2. When changes work and tests are OK, commit in repo `hal`
2. When changes are commited / merged:
   1. Get the hash id, and edit `cabal.project` with the **new commit id**
   2. run `./bin/update-project-dependencies`
      - get an error that sha256 don't match, so update the `./bin/update-project-dependencies` with new sha256 hash
      - run again `./bin/update-project-dependencies` (to make sure it's a fixed point now)

> Note: without `stack.yaml` we would have to only fix `cabal.project` -> `source-repository-package` commit id. Sha256 is there to make sure CI reruns the tests.

### GraphQL

Some introspection information.

Playground is located at http://localhost:8008/gql

#### List all GraphQL types in the Playground

```
{
  __schema {
    types {
      name
    }
  }
}
```

#### List details about a type in GraphQL

```
{
  __type(name:"User") {
  	fields {
    	name
      description
      type {
        name
      }
  	}
	}
}
```
### PostgreSQL <a name="pgsql"></a>

#### Upgrading using Docker

https://www.cloudytuts.com/tutorials/docker/how-to-upgrade-postgresql-in-docker-and-kubernetes/

To upgrade PostgreSQL in Docker containers, for example from 11.x to 14.x, simply run:
```shell
$ docker exec -it <container-id> pg_dumpall -U gargantua > 11-db.dump
```

Then, shut down the container, replace `image` section in `devops/docker/docker-compose.yaml` with `postgres:14`. Also, it is a good practice to create a new volume, say `garg-pgdata14` and bind the new container to it. If you want to keep the same volume, remember about removing it like so:
```shell
$ docker-compose rm postgres
$ docker volume rm docker_garg-pgdata
```

Now, start the container and execute:
```shell
$ # need to drop the empty DB first, since schema will be created when restoring the dump
$ docker exec -i <new-container-id> dropdb -U gargantua gargandbV5
$ # recreate the db, but empty with no schema
$ docker exec -i <new-container-id> createdb -U gargantua gargandbV5
$ # now we can restore the dump
$ docker exec -i <new-container-id> psql -U gargantua -d gargandbV5 < 11-db.dump
```

#### Upgrading using 

There is a solution using pgupgrade_cluster but you need to manage the clusters version 14 and 13. Hence here is a simple solution to upgrade.

First save your data:
```shell
$ sudo su postgres
$ pg_dumpall > gargandb.dump
```

Upgrade postgresql:
```shell
$ sudo apt install postgresql-server-14 postgresql-client-14
$ sudo apt remove --purge postgresql-13
```
Restore your data:
```shell
$ sudo su postgres
$ psql < gargandb.dump
```

Maybe you need to restore the gargantua password
```shell
$ ALTER ROLE gargantua PASSWORD 'yourPasswordIn_gargantext-settings.toml'
```

Maybe you need to change the port to 5433 for database connection in your gargantext.ini file.

## `haskell-language-server` <a name="haskell-language-server"></a>

If you want to use `haskell-language-server` for GHC 9.4.7, install it
with `ghcup`:
```shell
ghcup compile hls --version 2.7.0.0 --ghc 9.4.7
```
https://haskell-language-server.readthedocs.io/en/latest/installation.html


## Running the tests <a name="running-tests"></a>

Running the tests can be done via the following command:

```hs
cabal v2-test --test-show-details=streaming --flags 'test-crypto no-phylo-debug-logs'
```

The flags have the following meaning:

* `test-crypto`: Switch to use very fast (but not production-secure) cryptography, so that tests runs
  faster;
* `no-phylo-debug-logs`: Suppresses the debugging logs which would normally be present in phylo pure (!) code.

In order for some tests to run (like the phylo ones) is **required** to install the `gargantext-cli` via:

```hs
cabal v2-install gargantext:exe:gargantext
```

### Modifying a golden test to accept a new (expected) output

Some tests, like the Phylo one, use golden testing to ensure that the JSON Phylo we generate is
the same as an expected one. This allows us to catch regressions in the serialisation or in the algorithm.
Sometimes, however, we genuinely want to modify the output so that it's the new reference (i.e. the new
golden reference). To do so, it's enough to run the testsuite passing the `--accept` flag, for example:

```hs
cabal v2-test garg-test-tasty --test-show-details=streaming --flags 'test-crypto no-phylo-debug-logs' --test-option=--pattern='/Phylo/' --test-option=--accept"
```

# Async workers <a name="async-workers"></a>

## Steps to configure the worker

1. First create our Worker
```bash
createdb gargantext_pgmq
psql -c "ALTER DATABASE \"gargantext_pgmq\" OWNER TO \"gargantua\""
```
2. Then configure you gargantext-settings.toml (see next section)

3. Finally launch the worker
```bash
nix-shell --run "cabal v2-run gargantext -- worker run --name default"
```

Or launch all worker definitions at once:
```bash
nix-shell --run "cabal v2-run gargantext -- worker run-all"
```

## Configuration

Edit your `gargantext-settings.toml` file and add this section:
```toml
[worker]

# After this number of seconds, the job will be available again.
# You can set timeout for each job individually and this is the
# preferred method over using defaultVt.
default_visibility_timeout = 1

# default delay before job is visible to the worker
default_delay = 0

[worker.database]
host = "127.0.0.1"
port = 5432
name = "pgmq"
user = "gargantua"
pass = PASSWORD_TO_CHANGE

[[worker.definitions]]
name = "default"
queue = "default"
```

When running the worker for the first time (or sending a job), best
attempt is made to ensure the DB exists (if not, we will try to create
it) and the `pgmq` schema is initialized. This allows for hassle-free
maintenance and easier onboarding.

The way this is done is that we use the gargantext DB credentials as a
pivot to create the worker DB. This works of course if both DBs are on
the same server (`host` and `port` for both definitions must agree)
and the garg DB user can create new DBs. If they're on different
server, it is just assumed that the `worker.database` from above
config exists. See `G.C.W.Broker` -> `initBrokerWithDBCreate` for more
details.

# Notifications <a name="notifications"></a>

The notifications mechanism has 3 basic components: the `central
exchange`, the `dispatcher` and the `websocket server`.

## Configuration

See `gargantex-settings.toml_toModify`. Overall, the config for
notifications is quite simple:
```toml
[notifications]
central-exchange = { bind = "tcp://*:5560", connect = "tcp://localhost:5560" }
dispatcher = { bind = "tcp://*:5561", connect = "tcp://localhost:5561" }
```
The `bind`/`connect` strings are just forwarded to nanomsg, hence we
could switch `tcp` to `ipc` (but this limits us to a single machine)
or `inproc` (this limits us to inter-process communication).

The `bind` part is for the server, the `connect` part is for the
clients connecting to that server.
