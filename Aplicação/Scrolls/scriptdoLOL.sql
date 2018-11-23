USE [master]
GO
/****** Object:  Database [dbScrolls]    Script Date: 21/11/2018 11:04:25 ******/
CREATE DATABASE [dbScrolls]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'dbScrolls', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\dbScrolls.mdf' , SIZE = 4160KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'dbScrolls_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\dbScrolls_log.ldf' , SIZE = 1040KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [dbScrolls] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [dbScrolls].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [dbScrolls] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [dbScrolls] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [dbScrolls] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [dbScrolls] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [dbScrolls] SET ARITHABORT OFF 
GO
ALTER DATABASE [dbScrolls] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [dbScrolls] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [dbScrolls] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [dbScrolls] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [dbScrolls] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [dbScrolls] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [dbScrolls] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [dbScrolls] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [dbScrolls] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [dbScrolls] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [dbScrolls] SET  ENABLE_BROKER 
GO
ALTER DATABASE [dbScrolls] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [dbScrolls] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [dbScrolls] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [dbScrolls] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [dbScrolls] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [dbScrolls] SET READ_COMMITTED_SNAPSHOT ON 
GO
ALTER DATABASE [dbScrolls] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [dbScrolls] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [dbScrolls] SET  MULTI_USER 
GO
ALTER DATABASE [dbScrolls] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [dbScrolls] SET DB_CHAINING OFF 
GO
ALTER DATABASE [dbScrolls] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [dbScrolls] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [dbScrolls]
GO
/****** Object:  Table [dbo].[__MigrationHistory]    Script Date: 21/11/2018 11:04:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[__MigrationHistory](
	[MigrationId] [nvarchar](150) NOT NULL,
	[ContextKey] [nvarchar](300) NOT NULL,
	[Model] [varbinary](max) NOT NULL,
	[ProductVersion] [nvarchar](32) NOT NULL,
 CONSTRAINT [PK_dbo.__MigrationHistory] PRIMARY KEY CLUSTERED 
(
	[MigrationId] ASC,
	[ContextKey] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Avaliacao]    Script Date: 21/11/2018 11:04:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Avaliacao](
	[ClienteId] [int] NOT NULL,
	[ProdutoId] [int] NOT NULL,
	[Data] [datetime] NOT NULL,
	[Nota] [int] NOT NULL,
	[Comentario] [nvarchar](max) NULL,
 CONSTRAINT [PK_dbo.Avaliacao] PRIMARY KEY CLUSTERED 
(
	[ClienteId] ASC,
	[ProdutoId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Banner]    Script Date: 21/11/2018 11:04:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Banner](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Ativo] [bit] NOT NULL,
	[Latitude] [nvarchar](max) NULL,
	[Longitude] [nvarchar](max) NULL,
	[Imagem] [nvarchar](max) NULL,
	[Endereco_Id] [int] NULL,
 CONSTRAINT [PK_dbo.Banner] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Carrinho]    Script Date: 21/11/2018 11:04:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Carrinho](
	[ClienteId] [int] NOT NULL,
	[ProdutoId] [int] NOT NULL,
	[Quantidade] [int] NOT NULL,
 CONSTRAINT [PK_dbo.Carrinho] PRIMARY KEY CLUSTERED 
(
	[ClienteId] ASC,
	[ProdutoId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Cartao]    Script Date: 21/11/2018 11:04:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cartao](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Numero] [nvarchar](19) NOT NULL,
	[Nome] [nvarchar](50) NOT NULL,
	[Validade] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK_dbo.Cartao] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Categoria]    Script Date: 21/11/2018 11:04:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categoria](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Nome] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_dbo.Categoria] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Cliente]    Script Date: 21/11/2018 11:04:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cliente](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Nome] [nvarchar](15) NOT NULL,
	[Sobrenome] [nvarchar](50) NOT NULL,
	[Email] [nvarchar](320) NULL,
	[Imagem] [nvarchar](max) NULL,
	[CPF] [nvarchar](14) NOT NULL,
	[User] [nvarchar](15) NOT NULL,
	[Senha] [nvarchar](128) NOT NULL,
	[Cartao_Id] [int] NULL,
 CONSTRAINT [PK_dbo.Cliente] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ClienteCartao]    Script Date: 21/11/2018 11:04:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ClienteCartao](
	[ClienteId] [int] NOT NULL,
	[CartaoId] [int] NOT NULL,
 CONSTRAINT [PK_dbo.ClienteCartao] PRIMARY KEY CLUSTERED 
(
	[ClienteId] ASC,
	[CartaoId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Endereco]    Script Date: 21/11/2018 11:04:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Endereco](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[CEP] [nvarchar](max) NOT NULL,
	[Pais] [nvarchar](max) NOT NULL,
	[Estado] [nvarchar](max) NOT NULL,
	[Cidade] [nvarchar](max) NOT NULL,
	[Bairro] [nvarchar](max) NOT NULL,
	[Logradouro] [nvarchar](max) NOT NULL,
	[Complemento] [nvarchar](100) NULL,
	[Numero] [int] NOT NULL,
	[ClienteId] [int] NULL,
 CONSTRAINT [PK_dbo.Endereco] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Funcionario]    Script Date: 21/11/2018 11:04:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Funcionario](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Nome] [nvarchar](15) NOT NULL,
	[Sobrenome] [nvarchar](50) NOT NULL,
	[CPF] [nvarchar](14) NOT NULL,
	[Email] [nvarchar](320) NOT NULL,
	[Imagem] [nvarchar](max) NOT NULL,
	[Senha] [nvarchar](128) NOT NULL,
	[Gerente] [bit] NOT NULL,
	[EnderecoId] [int] NOT NULL,
 CONSTRAINT [PK_dbo.Funcionario] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Genero]    Script Date: 21/11/2018 11:04:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Genero](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Nome] [nvarchar](50) NOT NULL,
	[CategoriaId] [int] NOT NULL,
 CONSTRAINT [PK_dbo.Genero] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Imagem]    Script Date: 21/11/2018 11:04:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Imagem](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Caminho] [nvarchar](max) NULL,
	[ProdutoId] [int] NOT NULL,
 CONSTRAINT [PK_dbo.Imagem] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Produto]    Script Date: 21/11/2018 11:04:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Produto](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Nome] [nvarchar](max) NULL,
	[Descricao] [nvarchar](max) NULL,
	[Preco] [float] NOT NULL,
	[Quantidade] [int] NOT NULL,
	[Promocao] [float] NULL,
	[Complemento] [nvarchar](max) NULL,
	[Reposto] [datetime] NULL,
	[GeneroId] [int] NOT NULL,
	[Categoria_Id] [int] NULL,
 CONSTRAINT [PK_dbo.Produto] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ProdutoVenda]    Script Date: 21/11/2018 11:04:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProdutoVenda](
	[ProdutoId] [int] NOT NULL,
	[VendaId] [int] NOT NULL,
	[Quantidade] [int] NOT NULL,
	[PrecoVenda] [decimal](18, 2) NOT NULL,
 CONSTRAINT [PK_dbo.ProdutoVenda] PRIMARY KEY CLUSTERED 
(
	[ProdutoId] ASC,
	[VendaId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Venda]    Script Date: 21/11/2018 11:04:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Venda](
	[Id] [int] NOT NULL,
	[Data] [datetime] NOT NULL,
	[CartaoId] [int] NOT NULL,
	[ClienteId] [int] NOT NULL,
	[EnderecoId] [int] NOT NULL,
 CONSTRAINT [PK_dbo.Venda] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Index [IX_ClienteId]    Script Date: 21/11/2018 11:04:26 ******/
CREATE NONCLUSTERED INDEX [IX_ClienteId] ON [dbo].[Avaliacao]
(
	[ClienteId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_ProdutoId]    Script Date: 21/11/2018 11:04:26 ******/
CREATE NONCLUSTERED INDEX [IX_ProdutoId] ON [dbo].[Avaliacao]
(
	[ProdutoId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_Endereco_Id]    Script Date: 21/11/2018 11:04:26 ******/
CREATE NONCLUSTERED INDEX [IX_Endereco_Id] ON [dbo].[Banner]
(
	[Endereco_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_ClienteId]    Script Date: 21/11/2018 11:04:26 ******/
CREATE NONCLUSTERED INDEX [IX_ClienteId] ON [dbo].[Carrinho]
(
	[ClienteId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_ProdutoId]    Script Date: 21/11/2018 11:04:26 ******/
CREATE NONCLUSTERED INDEX [IX_ProdutoId] ON [dbo].[Carrinho]
(
	[ProdutoId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [IX_Numero]    Script Date: 21/11/2018 11:04:26 ******/
CREATE UNIQUE NONCLUSTERED INDEX [IX_Numero] ON [dbo].[Cartao]
(
	[Numero] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_Cartao_Id]    Script Date: 21/11/2018 11:04:26 ******/
CREATE NONCLUSTERED INDEX [IX_Cartao_Id] ON [dbo].[Cliente]
(
	[Cartao_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [IX_CPF]    Script Date: 21/11/2018 11:04:26 ******/
CREATE UNIQUE NONCLUSTERED INDEX [IX_CPF] ON [dbo].[Cliente]
(
	[CPF] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [IX_Email]    Script Date: 21/11/2018 11:04:26 ******/
CREATE UNIQUE NONCLUSTERED INDEX [IX_Email] ON [dbo].[Cliente]
(
	[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_CartaoId]    Script Date: 21/11/2018 11:04:26 ******/
CREATE NONCLUSTERED INDEX [IX_CartaoId] ON [dbo].[ClienteCartao]
(
	[CartaoId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_ClienteId]    Script Date: 21/11/2018 11:04:26 ******/
CREATE NONCLUSTERED INDEX [IX_ClienteId] ON [dbo].[ClienteCartao]
(
	[ClienteId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_ClienteId]    Script Date: 21/11/2018 11:04:26 ******/
CREATE NONCLUSTERED INDEX [IX_ClienteId] ON [dbo].[Endereco]
(
	[ClienteId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [IX_CPF]    Script Date: 21/11/2018 11:04:26 ******/
CREATE UNIQUE NONCLUSTERED INDEX [IX_CPF] ON [dbo].[Funcionario]
(
	[CPF] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [IX_Email]    Script Date: 21/11/2018 11:04:26 ******/
CREATE UNIQUE NONCLUSTERED INDEX [IX_Email] ON [dbo].[Funcionario]
(
	[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_EnderecoId]    Script Date: 21/11/2018 11:04:26 ******/
CREATE NONCLUSTERED INDEX [IX_EnderecoId] ON [dbo].[Funcionario]
(
	[EnderecoId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_CategoriaId]    Script Date: 21/11/2018 11:04:26 ******/
CREATE NONCLUSTERED INDEX [IX_CategoriaId] ON [dbo].[Genero]
(
	[CategoriaId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_ProdutoId]    Script Date: 21/11/2018 11:04:26 ******/
CREATE NONCLUSTERED INDEX [IX_ProdutoId] ON [dbo].[Imagem]
(
	[ProdutoId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_Categoria_Id]    Script Date: 21/11/2018 11:04:26 ******/
CREATE NONCLUSTERED INDEX [IX_Categoria_Id] ON [dbo].[Produto]
(
	[Categoria_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_GeneroId]    Script Date: 21/11/2018 11:04:26 ******/
CREATE NONCLUSTERED INDEX [IX_GeneroId] ON [dbo].[Produto]
(
	[GeneroId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_ProdutoId]    Script Date: 21/11/2018 11:04:26 ******/
CREATE NONCLUSTERED INDEX [IX_ProdutoId] ON [dbo].[ProdutoVenda]
(
	[ProdutoId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_VendaId]    Script Date: 21/11/2018 11:04:26 ******/
CREATE NONCLUSTERED INDEX [IX_VendaId] ON [dbo].[ProdutoVenda]
(
	[VendaId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_CartaoId]    Script Date: 21/11/2018 11:04:26 ******/
CREATE NONCLUSTERED INDEX [IX_CartaoId] ON [dbo].[Venda]
(
	[CartaoId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_ClienteId]    Script Date: 21/11/2018 11:04:26 ******/
CREATE NONCLUSTERED INDEX [IX_ClienteId] ON [dbo].[Venda]
(
	[ClienteId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_EnderecoId]    Script Date: 21/11/2018 11:04:26 ******/
CREATE NONCLUSTERED INDEX [IX_EnderecoId] ON [dbo].[Venda]
(
	[EnderecoId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Avaliacao]  WITH CHECK ADD  CONSTRAINT [FK_dbo.Avaliacao_dbo.Cliente_ClienteId] FOREIGN KEY([ClienteId])
REFERENCES [dbo].[Cliente] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Avaliacao] CHECK CONSTRAINT [FK_dbo.Avaliacao_dbo.Cliente_ClienteId]
GO
ALTER TABLE [dbo].[Avaliacao]  WITH CHECK ADD  CONSTRAINT [FK_dbo.Avaliacao_dbo.Produto_ProdutoId] FOREIGN KEY([ProdutoId])
REFERENCES [dbo].[Produto] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Avaliacao] CHECK CONSTRAINT [FK_dbo.Avaliacao_dbo.Produto_ProdutoId]
GO
ALTER TABLE [dbo].[Banner]  WITH CHECK ADD  CONSTRAINT [FK_dbo.Banner_dbo.Endereco_Endereco_Id] FOREIGN KEY([Endereco_Id])
REFERENCES [dbo].[Endereco] ([Id])
GO
ALTER TABLE [dbo].[Banner] CHECK CONSTRAINT [FK_dbo.Banner_dbo.Endereco_Endereco_Id]
GO
ALTER TABLE [dbo].[Carrinho]  WITH CHECK ADD  CONSTRAINT [FK_dbo.Carrinho_dbo.Cliente_ClienteId] FOREIGN KEY([ClienteId])
REFERENCES [dbo].[Cliente] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Carrinho] CHECK CONSTRAINT [FK_dbo.Carrinho_dbo.Cliente_ClienteId]
GO
ALTER TABLE [dbo].[Carrinho]  WITH CHECK ADD  CONSTRAINT [FK_dbo.Carrinho_dbo.Produto_ProdutoId] FOREIGN KEY([ProdutoId])
REFERENCES [dbo].[Produto] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Carrinho] CHECK CONSTRAINT [FK_dbo.Carrinho_dbo.Produto_ProdutoId]
GO
ALTER TABLE [dbo].[Cliente]  WITH CHECK ADD  CONSTRAINT [FK_dbo.Cliente_dbo.Cartao_Cartao_Id] FOREIGN KEY([Cartao_Id])
REFERENCES [dbo].[Cartao] ([Id])
GO
ALTER TABLE [dbo].[Cliente] CHECK CONSTRAINT [FK_dbo.Cliente_dbo.Cartao_Cartao_Id]
GO
ALTER TABLE [dbo].[ClienteCartao]  WITH CHECK ADD  CONSTRAINT [FK_dbo.ClienteCartao_dbo.Cartao_CartaoId] FOREIGN KEY([CartaoId])
REFERENCES [dbo].[Cartao] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ClienteCartao] CHECK CONSTRAINT [FK_dbo.ClienteCartao_dbo.Cartao_CartaoId]
GO
ALTER TABLE [dbo].[ClienteCartao]  WITH CHECK ADD  CONSTRAINT [FK_dbo.ClienteCartao_dbo.Cliente_ClienteId] FOREIGN KEY([ClienteId])
REFERENCES [dbo].[Cliente] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ClienteCartao] CHECK CONSTRAINT [FK_dbo.ClienteCartao_dbo.Cliente_ClienteId]
GO
ALTER TABLE [dbo].[Endereco]  WITH CHECK ADD  CONSTRAINT [FK_dbo.Endereco_dbo.Cliente_ClienteId] FOREIGN KEY([ClienteId])
REFERENCES [dbo].[Cliente] ([Id])
GO
ALTER TABLE [dbo].[Endereco] CHECK CONSTRAINT [FK_dbo.Endereco_dbo.Cliente_ClienteId]
GO
ALTER TABLE [dbo].[Funcionario]  WITH CHECK ADD  CONSTRAINT [FK_dbo.Funcionario_dbo.Endereco_EnderecoId] FOREIGN KEY([EnderecoId])
REFERENCES [dbo].[Endereco] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Funcionario] CHECK CONSTRAINT [FK_dbo.Funcionario_dbo.Endereco_EnderecoId]
GO
ALTER TABLE [dbo].[Genero]  WITH CHECK ADD  CONSTRAINT [FK_dbo.Genero_dbo.Categoria_CategoriaId] FOREIGN KEY([CategoriaId])
REFERENCES [dbo].[Categoria] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Genero] CHECK CONSTRAINT [FK_dbo.Genero_dbo.Categoria_CategoriaId]
GO
ALTER TABLE [dbo].[Imagem]  WITH CHECK ADD  CONSTRAINT [FK_dbo.Imagem_dbo.Produto_ProdutoId] FOREIGN KEY([ProdutoId])
REFERENCES [dbo].[Produto] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Imagem] CHECK CONSTRAINT [FK_dbo.Imagem_dbo.Produto_ProdutoId]
GO
ALTER TABLE [dbo].[Produto]  WITH CHECK ADD  CONSTRAINT [FK_dbo.Produto_dbo.Categoria_Categoria_Id] FOREIGN KEY([Categoria_Id])
REFERENCES [dbo].[Categoria] ([Id])
GO
ALTER TABLE [dbo].[Produto] CHECK CONSTRAINT [FK_dbo.Produto_dbo.Categoria_Categoria_Id]
GO
ALTER TABLE [dbo].[Produto]  WITH CHECK ADD  CONSTRAINT [FK_dbo.Produto_dbo.Genero_GeneroId] FOREIGN KEY([GeneroId])
REFERENCES [dbo].[Genero] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Produto] CHECK CONSTRAINT [FK_dbo.Produto_dbo.Genero_GeneroId]
GO
ALTER TABLE [dbo].[ProdutoVenda]  WITH CHECK ADD  CONSTRAINT [FK_dbo.ProdutoVenda_dbo.Produto_ProdutoId] FOREIGN KEY([ProdutoId])
REFERENCES [dbo].[Produto] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ProdutoVenda] CHECK CONSTRAINT [FK_dbo.ProdutoVenda_dbo.Produto_ProdutoId]
GO
ALTER TABLE [dbo].[ProdutoVenda]  WITH CHECK ADD  CONSTRAINT [FK_dbo.ProdutoVenda_dbo.Venda_VendaId] FOREIGN KEY([VendaId])
REFERENCES [dbo].[Venda] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ProdutoVenda] CHECK CONSTRAINT [FK_dbo.ProdutoVenda_dbo.Venda_VendaId]
GO
ALTER TABLE [dbo].[Venda]  WITH CHECK ADD  CONSTRAINT [FK_dbo.Venda_dbo.Cartao_CartaoId] FOREIGN KEY([CartaoId])
REFERENCES [dbo].[Cartao] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Venda] CHECK CONSTRAINT [FK_dbo.Venda_dbo.Cartao_CartaoId]
GO
ALTER TABLE [dbo].[Venda]  WITH CHECK ADD  CONSTRAINT [FK_dbo.Venda_dbo.Cliente_ClienteId] FOREIGN KEY([ClienteId])
REFERENCES [dbo].[Cliente] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Venda] CHECK CONSTRAINT [FK_dbo.Venda_dbo.Cliente_ClienteId]
GO
ALTER TABLE [dbo].[Venda]  WITH CHECK ADD  CONSTRAINT [FK_dbo.Venda_dbo.Endereco_EnderecoId] FOREIGN KEY([EnderecoId])
REFERENCES [dbo].[Endereco] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Venda] CHECK CONSTRAINT [FK_dbo.Venda_dbo.Endereco_EnderecoId]
GO
USE [master]
GO
ALTER DATABASE [dbScrolls] SET  READ_WRITE 
GO
