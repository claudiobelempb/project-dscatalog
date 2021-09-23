import styled, { css } from 'styled-components';

type HeadingProps = {
  upcase: boolean;
  iscolor: string;
};

export const HeadingH1 = styled.h1`
  position: relative;
  display: flex;
  ${({ theme }) => css<HeadingProps>`
    font-size: ${theme.fonts.sizes.lx};
    text-transform: ${(props) => (props.upcase ? 'uppercase' : 'none')};
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

export const HeadingH2 = styled.h2`
  position: relative;
  display: flex;
  ${({ theme }) => css<HeadingProps>`
    font-size: ${theme.fonts.sizes.mx};
    text-transform: ${(props) => (props.upcase ? 'uppercase' : 'none')};
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

export const HeadingH3 = styled.h3`
  position: relative;
  display: flex;
  ${({ theme }) => css<HeadingProps>`
    font-size: ${theme.fonts.sizes.sx};
    text-transform: ${(props) => (props.upcase ? 'uppercase' : 'none')};
    color: ${(props) =>
      props.iscolor ? props.iscolor : theme.colors.black_100};
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

export const HeadingH4 = styled.h4`
  position: relative;
  display: flex;
  ${({ theme }) => css<HeadingProps>`
    font-size: ${theme.fonts.sizes.sx};
    text-transform: ${(props) => (props.upcase ? 'uppercase' : 'none')};
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

export const HeadingH5 = styled.h5`
  position: relative;
  display: flex;
  ${({ theme }) => css<HeadingProps>`
    font-size: ${theme.fonts.sizes.lx};
    text-transform: ${(props) => (props.upcase ? 'uppercase' : 'none')};
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

export const HeadingH6 = styled.h6`
  position: relative;
  display: flex;
  ${({ theme }) => css<HeadingProps>`
    font-size: ${theme.fonts.sizes.ss};
    text-transform: ${(props) => (props.upcase ? 'uppercase' : 'none')};
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

// #HeadingContainer {
//   display: flex;
// }

// .font_lx {
//   font-size: var(--font-lx);
// }

// .font_mx {
//   font-size: var(--font-mx);
// }
// .font_sx {
//   font-size: var(--font-sx);
// }
// .font_ls {
//   font-size: var(--font-ls);
// }
// .font_ms {
//   font-size: var(--font-ms);
// }
// .font_ss {
//   font-size: var(--font-ss);
// }

// .isUppercase {
//   text-transform: uppercase;
// }
